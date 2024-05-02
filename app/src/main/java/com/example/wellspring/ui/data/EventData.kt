package com.example.wellspring.ui.data

import com.example.wellspring.R
import com.example.wellspring.ui.screens.EventItem

data class EventItem(
    val title: String,
    val time: String,
    val date: String,
    val location: String,
    val imageResId: Int
)

object EventData {
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
            R.drawable.image05),
        EventItem(
            "Interview Lab Workshop",
            "12:10 - 13:10",
            "Monday, April 22",
            "Online",
            R.drawable.image05)
    )
}