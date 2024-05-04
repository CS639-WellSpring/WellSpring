package com.example.wellspring.ui.components

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.wellspring.R
import com.example.wellspring.ui.theme.moodColorMap
import com.example.wellspring.ui.theme.moodIconMap
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun MoodSelectionDialog(
    showSheet: Boolean,
    selectedDate: LocalDate,
    onClose: () -> Unit,
    onSave: (String, String, LocalDate) -> Unit
) {
    if (showSheet) {
        Dialog(onDismissRequest = onClose) {
            MoodSelectionContent(selectedDate = selectedDate, onClose = onClose, onSave = onSave)
        }
    }
}

@Composable
fun MoodSelectionContent(
    selectedDate: LocalDate,
    onClose: () -> Unit,
    onSave: (String, String, LocalDate) -> Unit
) {
    var selectedMood by remember { mutableStateOf<String?>(null) }
    var journalText by remember { mutableStateOf("") }

    Card(modifier = Modifier.padding(16.dp), elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                "${selectedDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"))}",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                moodColorMap.forEach { (mood, color) ->
                    val iconId = moodIconMap[mood] ?: R.drawable.ic_default_mood
                    MoodButton(
                        mood = mood,
                        moodColor = color,
                        isSelected = mood == selectedMood,
                        iconPainter = painterResource(id = iconId),
                        onSelectionChanged = { newMood ->
                            selectedMood = if (selectedMood != newMood) newMood else null
                            println("Mood selected: $newMood")
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            BasicTextField(
                value = journalText,
                onValueChange = { journalText = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .padding(8.dp),
                textStyle = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onSurface),
                decorationBox = { innerTextField ->
                    if (journalText.isEmpty()) {
                        Text("Type your note here...", color = Color.Gray)
                    }
                    innerTextField()
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = onClose,
                    colors = ButtonDefaults.outlinedButtonColors()
                ) {
                    Text("Cancel")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = {
                        selectedMood?.let { mood ->
                            println("Saving Mood: $mood on $selectedDate with journal: $journalText")
                            onSave(mood, journalText, selectedDate)
                            onClose()
                        } ?: println("No mood selected.")
                    }
                ) {
                    Text("Save")
                }
            }
        }
    }
}

@Composable
fun MoodButton(
    mood: String,
    moodColor: Color,
    isSelected: Boolean,
    iconPainter: Painter,
    onSelectionChanged: (String) -> Unit
) {
    val backgroundColor = if (isSelected) moodColor else Color.Transparent
    val iconTintColor = if (isSelected) MaterialTheme.colorScheme.onSurface else moodColor

    IconButton(
        onClick = { onSelectionChanged(mood) },
        modifier = Modifier
            .size(51.dp)
            .background(color = backgroundColor, shape = CircleShape)
    ) {
        Icon(
            painter = iconPainter,
            contentDescription = mood,
            tint = iconTintColor
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMoodSelectionDialog() {
    MoodSelectionDialog(
        showSheet = true,
        selectedDate = LocalDate.now(),
        onClose = {},
        onSave = { _, _,_ -> }
    )
}




