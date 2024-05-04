package com.example.wellspring.ui.theme

import androidx.compose.ui.graphics.Color
import com.example.wellspring.R

val Excited = Color(0xFFFFA340)
val Happy = Color(0xFFFFD65D)
val Peace = Color(0xFF3CCD4C)
val Bored = Color(0xFFB9C5C1)
val Worried = Color(0xFFC4A8C7)
val Sad = Color(0xFF45679E)

val moodColorMap = mapOf(
    "Excited" to Excited,
    "Happy" to Happy,
    "Peace" to Peace,
    "Bored" to Bored,
    "Worried" to Worried,
    "Sad" to Sad
)
val moodIconMap = mapOf(
    "Excited" to R.drawable.ic_excited,
    "Happy" to R.drawable.ic_happy,
    "Peace" to R.drawable.ic_peace,
    "Bored" to R.drawable.ic_bored,
    "Worried" to R.drawable.ic_worried,
    "Sad" to R.drawable.ic_sad
)


val barColor = Color(0xFFFFD7E3)
var holeColor = Color(0x00000000)

object Color {
    val primary = Color(0xFF6750A4)
    val onPrimary = Color(0xFFFFFFFF)
    val primaryContainer = Color(0xFFEADDFF)
    val onPrimaryContainer = Color(0xFF21005D)
    val secondary = Color(0xFF625B71)
    val onSecondary = Color(0xFFFFFFFF)
    val secondaryContainer = Color(0xFFE8DEF8)
    val onSecondaryContainer = Color(0xFF1D192B)
    val surfaceContainer = Color(0xFFF3F0FB)
    val onSurface = Color(0xFF212121)

    val primaryDark = Color(0xFFD0BCFF)
    val onPrimaryDark = Color(0xFF381E72)
    val primaryContainerDark = Color(0xFF4F378B)
    val onPrimaryContainerDark = Color(0xFFEADDFF)
    val secondaryDark = Color(0xFFCCC2DC)
    val onSecondaryDark = Color(0xFF332D41)
    val secondaryContainerDark = Color(0xFF4A4458)
    val onSecondaryContainerDark = Color(0xFFE8DEF8)
    val onSurfaceDark = Color(0xFFE0E0E0)
}

