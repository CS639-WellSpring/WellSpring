package com.example.wellspring.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wellspring.R
import com.example.wellspring.components.MonthPicker
import com.example.wellspring.components.MonthPickerDialog
import com.example.wellspring.components.MoodSelectionSheet
import com.example.wellspring.ui.theme.AppTheme
import java.time.LocalDate
import java.time.YearMonth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoodScreen(navController: NavHostController) {
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }
    var showMoodSheet by remember { mutableStateOf(false) }
    var selectedMonth by remember { mutableStateOf(YearMonth.now()) }
    var showMonthPicker by remember { mutableStateOf(false) }

    AppTheme {
        Scaffold(
            topBar = {
                MediumTopAppBar(
                    title = {
                        MonthPicker(selectedMonth, onMonthClick = { showMonthPicker = true })
                    },
                    actions = {
                        IconButton(onClick = { /* Implement Profile click action here if needed */ }) {
                            Icon(Icons.Filled.AccountCircle, contentDescription = "Profile")
                        }
                    }
                )
            },
            bottomBar = {
                MoodBottomNavigationBar(navController)
            }
        ) { innerPadding ->
            BodyContent(innerPadding, selectedDate, showMoodSheet, onDateSelected = { date ->
                selectedDate = date
                showMoodSheet = true
            })
            if (showMonthPicker) {
                MonthPickerDialog(selectedMonth, onMonthSelected = { month ->
                    selectedMonth = month
                    showMonthPicker = false
                }, onDismiss = {
                    showMonthPicker = false
                })
            }
        }
    }
}

@Composable
fun BodyContent(
    paddingValues: PaddingValues,
    selectedDate: LocalDate,
    showMoodSheet: Boolean,
    onDateSelected: (LocalDate) -> Unit
) {
    Column(modifier = Modifier.padding(paddingValues)) {
        Text("Select a Date to Add Mood:", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onDateSelected(LocalDate.now()) }) {
            Text("Select Today")
        }
        if (showMoodSheet) {
            MoodSelectionSheet(date = selectedDate, onMoodSelected = { mood ->
                // Here, add the mood to your database or state management
                println("Mood selected: $mood on date: $selectedDate")
            }, onDismiss = {
                // Handle cleanup here
            })
        }
    }
}


@Composable
fun MoodBottomNavigationBar(navController: NavHostController) {
    val context = LocalContext.current
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.ic_events_outline), contentDescription = "Events") },
            label = { Text("Events") },
            selected = false,
            onClick = { navController.navigate("events") }
        )
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.ic_mood_filled), contentDescription = "Mood") },
            label = { Text("Mood") },
            selected = true,
            onClick = { /* Handle Mood click */ }
        )
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.ic_chart_outline), contentDescription = "Chart") },
            label = { Text("Chart") },
            selected = false,
            onClick = { navController.navigate("chart") }
        )
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        // Your content here
        Text("Your main content here", Modifier.align(Alignment.Center))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMoodScreen() {
    val navController = rememberNavController()
    MoodScreen(navController)
}
