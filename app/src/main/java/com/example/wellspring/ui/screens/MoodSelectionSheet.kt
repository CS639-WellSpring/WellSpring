package com.example.wellspring.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheetLayout
import androidx.compose.material3.ModalBottomSheetValue
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wellspring.ui.data.MoodData
import com.example.wellspring.ui.data.MoodRecord
import kotlinx.coroutines.launch
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoodSelectionSheet(
    date: LocalDate,
    onDismiss: () -> Unit
) {
    val moods = listOf("Excited", "Happy", "Sad", "Peace", "Worried", "Bored")
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = {
            Column(modifier = Modifier.padding(16.dp)) {
                moods.forEach { mood ->
                    Button(
                        onClick = {
                            MoodData.addMoodRecord(MoodRecord(date, mood))
                            scope.launch {
                                sheetState.hide()
                            }
                            onDismiss()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Text(mood)
                    }
                }
            }
        }
    ) {
        // Trigger to open the bottom sheet could go here
    }


    scope.launch {
        sheetState.show()
    }
}

