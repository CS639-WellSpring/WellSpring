package com.example.wellspring.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wellspring.R
import com.example.wellspring.ui.components.TopAppBarWithMenu
import com.example.wellspring.ui.data.JournalData
import com.example.wellspring.ui.data.JournalEntry
import com.example.wellspring.ui.data.MoodData
import com.example.wellspring.ui.theme.Color.surfaceContainer
import com.example.wellspring.ui.theme.moodColorMap
import com.example.wellspring.ui.theme.moodIconMap
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JournalScreen(navController: NavHostController) {
    val journalEntries = JournalData.getAllEntries()

    Scaffold(
        topBar = { TopAppBarWithMenu(navController) },
        bottomBar = { JournalBottomNavigationBar(navController) }
    ) { innerPadding ->
        JournalList(journalEntries = journalEntries, modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun JournalList(journalEntries: List<JournalEntry>, modifier: Modifier) {
    val sortedEntries = journalEntries.sortedByDescending { it.date }

    LazyColumn(
        modifier = modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(sortedEntries) { entry ->
            JournalRow(entry)
        }
    }
}

@Composable
fun JournalRow(entry: JournalEntry) {
    val moodEntry = remember { MoodData.getMood(entry.date) }
    val moodIconId = moodEntry?.let { moodIconMap[it.mood] } ?: R.drawable.ic_default_mood
    val backgroundColor = moodEntry?.let { moodColorMap[it.mood] } ?: Color.LightGray

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(108.dp),
        shape = RoundedCornerShape(32.dp),
        color = surfaceContainer
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(48.dp)
                    .background(backgroundColor, shape = CircleShape)
            ) {
                Image(
                    painter = painterResource(id = moodIconId),
                    contentDescription = "Mood Icon",
                    modifier = Modifier.size(48.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = entry.date.format(DateTimeFormatter.ISO_LOCAL_DATE),
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = entry.text,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Composable
fun JournalBottomNavigationBar(navController: NavHostController) {
    val context = LocalContext.current
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.ic_events_outline), contentDescription = "Events") },
            label = { Text("Events") },
            selected = false,
            onClick = { }
        )
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.ic_mood_outline), contentDescription = "Mood") },
            label = { Text("Mood") },
            selected = false,
            onClick = { navController.navigate("mood") }
        )
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.ic_journal_filled), contentDescription = "Journal") },
            label = { Text("Journal") },
            selected = true,
            onClick = { navController.navigate("journal") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewJournalScreen() {
    val navController = rememberNavController()
    JournalScreen(navController)
}