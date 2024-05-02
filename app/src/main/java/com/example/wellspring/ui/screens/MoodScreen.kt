package com.example.wellspring.ui.screens

import android.widget.CalendarView
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowDropDown
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wellspring.R
import com.example.wellspring.ui.data.MoodData
import com.example.wellspring.ui.data.MoodRecord
import com.example.wellspring.ui.theme.AppTheme
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoodScreen(navController: NavHostController) {
    var selectedMonth by remember { mutableStateOf(YearMonth.now()) }
    var showMonthPicker by remember { mutableStateOf(false) }
    var showMoodSheet by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }

    AppTheme {
        Scaffold(
            topBar = {
                MediumTopAppBar(
                    title = {
                        MonthPicker(selectedMonth, onMonthClick = { showMonthPicker = true })
                    },
                    actions = {
                        IconButton(onClick = { /* Handle profile click */ }) {
                            Icon(Icons.Filled.AccountCircle, contentDescription = "Profile")
                        }
                    }
                )
            },
            bottomBar = {
                MoodBottomNavigationBar(navController)
            },
        ) { innerPadding ->
            BodyContent(innerPadding, selectedMonth, showMonthPicker, showMoodSheet, selectedDate)
        }
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



@Composable
fun BodyContent(
        paddingValues: PaddingValues,
        selectedMonth: YearMonth,
        showMonthPicker: Boolean,
        showMoodSheet: Boolean,
        selectedDate: LocalDate
    ) {
        Column(modifier = Modifier.padding(paddingValues)) {
            CalendarView(selectedMonth) { date ->
                selectedDate = date
                showMoodSheet = true
            }
            if (showMoodSheet) {
                MoodSelectionSheet(selectedDate) { mood ->
                    MoodData.addMoodRecord(MoodRecord(selectedDate, mood))
                    showMoodSheet = false
                }
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
