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
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wellspring.R
import com.example.wellspring.ui.components.TopAppBarWithMenu
import com.example.wellspring.data.EventData
import com.example.wellspring.ui.theme.Color.surfaceContainer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventsScreen(navController: NavHostController) {
    val scrollState = rememberLazyListState()
    val shouldShowAppBar = remember { mutableStateOf(true) }
    LaunchedEffect(scrollState.firstVisibleItemIndex, scrollState.firstVisibleItemScrollOffset) {
        val showTopBar = scrollState.firstVisibleItemScrollOffset <= 0 && scrollState.firstVisibleItemIndex == 0
        shouldShowAppBar.value = showTopBar
    }

    Scaffold(
        topBar = { TopAppBarWithMenu(navController, title = "Events") },
        bottomBar = { EventsBottomNavigationBar(navController) }
    ) { innerPadding ->
        EventsList(events = EventData.events, modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun EventsList(events: List<EventItem>, modifier: Modifier) {
    LazyColumn(
        modifier = modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
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
            .height(108.dp),
        shape = RoundedCornerShape(32.dp),
        color = surfaceContainer
    ) {
        Row(
            modifier = Modifier.fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = event.imageResId),
                contentDescription = "Event Photo",
                modifier = Modifier
                    .width(108.dp)
                    .fillMaxHeight()
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = event.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
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
fun EventsBottomNavigationBar(navController: NavHostController) {
    val context = LocalContext.current
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.ic_events_filled), contentDescription = "Events") },
            label = { Text("Events") },
            selected = true,
            onClick = { }
        )
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.ic_mood_outline), contentDescription = "Mood") },
            label = { Text("Mood") },
            selected = false,
            onClick = { navController.navigate("mood") }
        )
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.ic_journal_outline), contentDescription = "Journal") },
            label = { Text("Journal") },
            selected = false,
            onClick = { navController.navigate("journal") }
        )
    }
}

data class EventItem(
    val title: String,
    val time: String,
    val date: String,
    val location: String,
    val imageResId: Int
)

@Preview(showBackground = true)
@Composable
fun PreviewEventsScreen() {
    val navController = rememberNavController()
    EventsScreen(navController)
}