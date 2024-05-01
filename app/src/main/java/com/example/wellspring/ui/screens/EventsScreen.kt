package com.example.wellspring.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wellspring.R
import com.example.wellspring.ui.theme.AppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventsScreen() {
    AppTheme {

        Scaffold(
            topBar = {
                LargeTopAppBar(
                    title = { Text("Events", style = MaterialTheme.typography.headlineLarge) },
                    actions = {
                        IconButton(onClick = { /* TODO: Handle profile click */ }) {
                            Icon(Icons.Filled.AccountCircle, contentDescription = "Profile")
                        }
                    }
                )
            },
            bottomBar = {
                BottomNavigationBar()
            }
        ) { innerPadding ->
            EventsList(Modifier.padding(innerPadding))
        }
    }
}

@Composable
fun EventsList(modifier: Modifier = Modifier) {
    val events = listOf(
        EventItem(
            "Slime Making",
            "13:00 - 14:00",
            "Saturday, April 20",
            "15 Beekman St, 25th floor",
            R.drawable.image01),
        EventItem(
            "End of Semester Awards",
            "18:00 - 20:00",
            "Saturday, April 20",
            "15 Beekman St, Aniello Bianco Room",
            R.drawable.image02),
        EventItem(
            "The Collective: Spring Showcase",
            "20:00 - 22:00",
            "Saturday, April 20",
            "KnJ Theatre",
            R.drawable.image03),
        EventItem(
            "P.A.C.E. Board Food Trucks",
            "12:00 - 14:00",
            "Monday, April 22",
            "1 Pace Plaza Outside",
            R.drawable.image04),
        EventItem(
            "Interview Lab Workshop",
            "12:10 - 13:10",
            "Monday, April 22",
            "Online",
            R.drawable.image05)
    )

    LazyColumn(
        modifier = modifier
            .padding(horizontal = 16.dp)  // Apply horizontal padding here
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp) // This adds spacing between items
    ) {
        items(events) { event ->
            EventRow(event)
        }
    }
}

@Composable
fun EventRow(event: EventItem) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(108.dp), // Fixed height for the container
        shape = RoundedCornerShape(32.dp),
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Row(
            modifier = Modifier.fillMaxHeight(), // Ensure the Row fills the Surface height
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = event.imageResId),
                contentDescription = "Event Photo",
                modifier = Modifier
                    .width(108.dp) // Make the image square and equal to the height of the container
                    .fillMaxHeight() // Image fills the vertical space of the container
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.padding(vertical = 16.dp) // Apply vertical padding only here for text
            ) {
                Text(
                    text = event.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = event.time,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = event.date,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = event.location,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}


@Composable
fun BottomNavigationBar() {
    val context = LocalContext.current
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.ic_events_filled), contentDescription = "Events") },
            label = { Text("Events") },
            selected = true,
            onClick = { /* Handle Events click */ }
        )
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.ic_mood_outline), contentDescription = "Mood") },
            label = { Text("Mood") },
            selected = false,
            onClick = { /* Handle Mood click */ }
        )
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.ic_chart_outline), contentDescription = "Chart") },
            label = { Text("Chart") },
            selected = false,
            onClick = { /* Handle Chart click */ }
        )
    }
}

data class EventItem(
    val title: String,
    val time: String,
    val date: String,
    val location: String,
    val imageResId: Int  // Drawable resource ID for the event image
)

@Preview(showBackground = true)
@Composable
fun PreviewEventsScreen() {
    AppTheme { // Wrap in the app theme to apply styles
        EventsScreen()
    }
}