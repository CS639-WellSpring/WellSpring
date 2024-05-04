package com.example.wellspring.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wellspring.R
import com.example.wellspring.ui.calendar.sample.compose.clickable
import com.example.wellspring.ui.calendar.sample.compose.rememberFirstMostVisibleMonth
import com.example.wellspring.ui.components.MonthPicker
import com.example.wellspring.ui.components.MoodSelectionDialog
import com.example.wellspring.ui.components.TopAppBarWithMenu
import com.example.wellspring.ui.data.MoodData
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
import com.kizitonwose.calendar.core.nextMonth
import com.kizitonwose.calendar.core.previousMonth
import com.kizitonwose.calendar.sample.compose.SimpleCalendarTitle
import com.kizitonwose.calendar.sample.shared.displayText
import kotlinx.coroutines.launch
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
            topBar = { TopAppBarWithMenu(navController) },
            bottomBar = {
                MoodBottomNavigationBar(navController)
            },
            floatingActionButton = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp)
                ) {
                    FloatingActionButton(
                        onClick = { navController.navigate("chart") },
                        modifier = Modifier.size(40.dp)
                    ) {

                        Icon(painterResource(id = R.drawable.ic_chart), contentDescription = "View Chart")
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
            Column(modifier = Modifier.padding(innerPadding)) {
                CalendarGrid(adjacentMonths = 500L)
            }
            if (showMoodSheet) {
                MoodSelectionDialog(
                    showSheet = showMoodSheet,
                    onClose = { showMoodSheet = false },
                    onSave = { mood, journalText ->
                        showMoodSheet = false
                    }
                )
            }
        }
    }
}

@Composable
fun CalendarGrid(adjacentMonths: Long = 500) {
    val currentMonth = remember { YearMonth.now() }
    val startMonth = remember { currentMonth.minusMonths(adjacentMonths) }
    val endMonth = remember { currentMonth.plusMonths(adjacentMonths) }
    val selections = remember { mutableStateListOf<CalendarDay>() }
    val daysOfWeek = remember { daysOfWeek() }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        val state = rememberCalendarState(
            startMonth = startMonth,
            endMonth = endMonth,
            firstVisibleMonth = currentMonth,
            firstDayOfWeek = daysOfWeek.first(),
        )
        val coroutineScope = rememberCoroutineScope()
        val visibleMonth = rememberFirstMostVisibleMonth(state, viewportPercent = 90f)
        SimpleCalendarTitle(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 8.dp),
            currentMonth = visibleMonth.yearMonth,
            goToPrevious = {
                coroutineScope.launch {
                    state.animateScrollToMonth(state.firstVisibleMonth.yearMonth.previousMonth)
                }
            },
            goToNext = {
                coroutineScope.launch {
                    state.animateScrollToMonth(state.firstVisibleMonth.yearMonth.nextMonth)
                }
            },
        )
        HorizontalCalendar(
            modifier = Modifier.testTag("Calendar"),
            state = state,
            dayContent = { day ->
                Day(day, isSelected = selections.contains(day)) { clicked ->
                    if (selections.contains(clicked)) {
                        selections.remove(clicked)
                    } else {
                        selections.add(clicked)
                    }
                }
            },
            monthHeader = {
                MonthHeader(daysOfWeek = daysOfWeek)
            },
        )
    }
}

@Composable
private fun MonthHeader(daysOfWeek: List<DayOfWeek>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("MonthHeader"),
    ) {
        for (dayOfWeek in daysOfWeek) {
            androidx.compose.material.Text(
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                text = dayOfWeek.displayText(),
                fontWeight = FontWeight.Medium,
            )
        }
    }
}

@Composable
private fun Day(day: CalendarDay, isSelected: Boolean, onClick: (CalendarDay) -> Unit) {
    val moodColor = remember(day.date) {
        MoodData.getMoodForDate(day.date)?.let { mood ->
            moodColorMap[mood] ?: Color.Transparent
        } ?: Color.Transparent
    }

    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .testTag("MonthDay")
            .padding(6.dp)
            .clip(CircleShape)
            .background(color = moodColor)
            .clickable(
                enabled = day.position == DayPosition.MonthDate,
                showRipple = !isSelected,
                onClick = { onClick(day) },
            ),
        contentAlignment = Alignment.Center,
    ) {
        val textColor = when (day.position) {
            DayPosition.MonthDate -> if (isSelected) Color.White else Color.Unspecified
            DayPosition.InDate, DayPosition.OutDate -> colorResource(R.color.inactive_text_color)
        }
        androidx.compose.material.Text(
            text = day.date.dayOfMonth.toString(),
            color = textColor,
            fontSize = 14.sp,
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

