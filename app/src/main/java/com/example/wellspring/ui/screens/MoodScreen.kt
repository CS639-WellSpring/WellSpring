package com.example.wellspring.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
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
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wellspring.R
import com.example.wellspring.ui.components.MonthPicker
import com.example.wellspring.ui.components.MoodSelectionDialog
import com.example.wellspring.ui.data.MoodData.getMoodForDate
import com.example.wellspring.ui.theme.AppTheme
import com.example.wellspring.ui.theme.moodColorMap
import com.kizitonwose.calendar.compose.HorizontalCalendar
import com.kizitonwose.calendar.compose.rememberCalendarState
import java.time.LocalDate
import java.time.YearMonth
import com.kizitonwose.calendar.core.CalendarDay
import com.kizitonwose.calendar.core.DayPosition
import com.kizitonwose.calendar.core.daysOfWeek
import java.time.DayOfWeek
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoodScreen(navController: NavHostController) {
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }
    var selectedMonth by remember { mutableStateOf(YearMonth.now()) }
    var showMoodSheet by remember { mutableStateOf(false) }
    var showMonthPicker by remember { mutableStateOf(false) }


    AppTheme {
        Scaffold(
            topBar = {
                MediumTopAppBar(
                    title = {
                    },
                    actions = {
                        IconButton(onClick = { navController.navigate("chart") }) {
                            Icon(painterResource(id = R.drawable.ic_chart), contentDescription = "Chart")
                        }
                        IconButton(onClick = { /* Implement Profile click action here if needed */ }) {
                            Icon(Icons.Filled.AccountCircle, contentDescription = "Profile")
                        }
                    }
                )
            },
            bottomBar = {
                MoodBottomNavigationBar(navController)
            },
            floatingActionButton = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp)
                ) {
                    FloatingActionButton(
                        onClick = { navController.navigate("journal") },
                        modifier = Modifier.size(40.dp)
                    ) {
                        Icon(Icons.Filled.Edit, contentDescription = "Add Journal")
                    }
                    Spacer(Modifier.height(20.dp))
                    FloatingActionButton(
                        onClick = { showMoodSheet = true },
                        modifier = Modifier.size(56.dp)
                    ) {
                        Icon(Icons.Filled.Add, contentDescription = "Add Mood")
                    }
                }
            }
        ) { innerPadding ->
            MoodCalendarContent(innerPadding, selectedDate, onDateChange = { date -> selectedDate = date })
            if (showMoodSheet) {
                MoodSelectionDialog(
                    showSheet = showMoodSheet,
                    onClose = { showMoodSheet = false },
                    onSave = { mood, journalText ->
                        showMoodSheet = false
                    }
                )
            }
            if (showMonthPicker) {
                MonthPicker(
                    visible = showMonthPicker,
                    currentMonth = selectedMonth.monthValue - 1,
                    currentYear = selectedMonth.year,
                    confirmButtonClicked = { month, year ->
                        selectedMonth = YearMonth.of(year, month)
                        showMonthPicker = false
                    },
                    cancelClicked = {
                        showMonthPicker = false
                    }
                )
            }
        }
    }
}

@Composable
fun MoodCalendarContent(paddingValues: PaddingValues, selectedDate: LocalDate, onDateChange: (LocalDate) -> Unit) {
    val daysOfWeek = daysOfWeek(firstDayOfWeek = DayOfWeek.MONDAY)
    Column(modifier = Modifier.padding(paddingValues)) {
        DaysOfWeekTitle(daysOfWeek = daysOfWeek)
        HorizontalCalendar(
            state = rememberCalendarState(),
            dayContent = { day ->
                DayContent(day, selectedDate, onDateChange)
            }
        )
    }
}

@Composable
fun DaysOfWeekTitle(daysOfWeek: List<DayOfWeek>) {
    Row(modifier = Modifier.fillMaxWidth()) {
        for (dayOfWeek in daysOfWeek) {
            Text(
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                text = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault()),
            )
        }
    }
}

@Composable
fun DayContent(day: CalendarDay, selectedDate: LocalDate, onDateSelected: (LocalDate) -> Unit) {
    val mood = getMoodForDate(day.date)
    val moodColor = moodColorMap[mood] ?: Color.White

    Box(modifier = Modifier
        .padding(4.dp)
        .height(48.dp)
        .background(color = moodColor, shape = CircleShape)
        .clickable { onDateSelected(day.date) }
        .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = day.date.dayOfMonth.toString(),
            textAlign = TextAlign.Center,
            color = if (day.position == DayPosition.MonthDate) Color.Black else Color.Gray,
            style = MaterialTheme.typography.bodyMedium
        )
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
            icon = { Icon(painterResource(id = R.drawable.ic_journal_outline), contentDescription = "Journal") },
            label = { Text("Journal") },
            selected = false,
            onClick = { navController.navigate("journal") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMoodScreen() {
    val navController = rememberNavController()
    MoodScreen(navController)
}

