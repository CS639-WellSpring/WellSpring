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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.wellspring.R
import com.example.wellspring.ui.theme.moodColorMap
import com.example.wellspring.ui.theme.moodIconMap

@Composable
fun MoodSelectionDialog(
    showSheet: Boolean,
    onClose: () -> Unit,
    onSave: (String, String) -> Unit
) {
    if (showSheet) {
        Dialog(onDismissRequest = onClose) {
            MoodSelectionContent(onClose = onClose, onSave = onSave)
        }
    }
}

@Composable
fun MoodSelectionContent(
    onClose: () -> Unit,
    onSave: (String, String) -> Unit
) {
    var selectedMood by remember { mutableStateOf<String?>(null) }
    var journalText by remember { mutableStateOf("") }

    Card(modifier = Modifier.padding(16.dp), elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Spacer(modifier = Modifier.height(16.dp))
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
                textStyle = MaterialTheme.typography.bodyLarge.copy(color = Color.Black),
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
                            onSave(mood, journalText)
                            onClose()
                        }
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
    val iconTintColor = if (isSelected) Color.Black else moodColor

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
fun PreviewMoodSelectionSheetDialog() {
    val context = LocalContext.current

    val onSave: (String, String) -> Unit = { mood, journalText ->
        println("Mood: $mood, Journal: $journalText")
    }

    MoodSelectionDialog(
        showSheet = true,
        onClose = {},
        onSave = onSave
    )
}



