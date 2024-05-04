package com.example.wellspring.repository

import com.example.wellspring.models.Journals
import com.google.firebase.Firebase
import com.google.firebase.Timestamp
import com.google.firebase.auth.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

const val JOURNALS_COLLECTION_REF = "journals"

class StorageRepository() {

    val user = Firebase.auth.currentUser
    fun hasUser(): Boolean = Firebase.auth.currentUser != null

    fun getUserId(): String = Firebase.auth.currentUser?.uid.orEmpty()

    private val journalsRef: CollectionReference = Firebase
        .firestore.collection(JOURNALS_COLLECTION_REF)

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getUserJournals(
        userId: String
    ): Flow<Resources<List<Journals>>> = callbackFlow {
        var snapshotStateListener:ListenerRegistration? = null

        try {
            snapshotStateListener = journalsRef
                .orderBy("timestamp")
                .whereEqualTo("userId", userId)
                .addSnapshotListener { snapshot, e ->
                    val response = if (snapshot != null) {
                        val journals = snapshot.toObjects(Journals::class.java)
                        Resources.Success(data = journals)
                    }else{
                        Resources.Error(throwable = e?.cause)
                    }
                    trySend(response)
                }

        } catch (e:Exception){
            trySend(Resources.Error(e.cause))
            e.printStackTrace()
        }

        awaitClose{
            snapshotStateListener?.remove()
        }
    }

    fun getJournal(
        journalId:String,
        onError:(Throwable?) -> Unit,
        onSuccess:(Journals?) -> Unit
    ) {
        journalsRef
            .document(journalId)
            .get()
            .addOnSuccessListener {
                onSuccess.invoke(it?.toObject(Journals::class.java))
            }
            .addOnFailureListener {result ->
                onError.invoke(result.cause)
            }
    }

    fun addJournal(
        userId: String,
        title: String,
        description: String,
        timestamp: Timestamp,
        onComplete: (Boolean) -> Unit,
    ) {
        val documentId = journalsRef.document().id
        val journal = Journals(userId, title, description, timestamp)
        journalsRef




    }

}

sealed class Resources<T>(
    val data: T? = null,
    val throwable: Throwable? =null,
) {
    class Loading<T>:Resources<T>()
    class Success<T>(data: T?):Resources<T>(data = data)
    class Error<T>(throwable: Throwable?):Resources<T>(throwable = throwable)
}