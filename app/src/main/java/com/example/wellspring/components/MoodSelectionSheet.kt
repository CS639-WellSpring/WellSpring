package com.example.wellspring.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.time.LocalDate


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MoodSelectionSheet(
    date: LocalDate,
    onMoodSelected: (String) -> Unit,
    onDismiss: () -> Unit
) {
    val moods = listOf("Excited", "Happy", "Sad", "Peace", "Worried", "Bored")
    val showModal = remember { mutableStateOf(false) }

    if (showModal.value) {
        ModalBottomSheetLayout(
            sheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden),
            sheetContent = {
                Column(modifier = Modifier.padding(16.dp)) {
                    moods.forEach { mood ->
                        Button(
                            onClick = {
                                onMoodSelected(mood)
                                showModal.value = false
                                onDismiss()
                            },
                            modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
                        ) {
                            Text(mood)
                        }
                    }
                }
            }
        ) {
            // Content that triggers the bottom sheet
            Button(
                onClick = { showModal.value = true },
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                Text("Select Mood")
            }
        }
    }
}




