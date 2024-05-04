package com.example.wellspring.models

import com.google.firebase.Timestamp

data class Journals(
    val userId:String = "",
    val title:String = "",
    val description:String = "",
    val timestamp: Timestamp = Timestamp.now(),
    val documentId: String = "",
)

