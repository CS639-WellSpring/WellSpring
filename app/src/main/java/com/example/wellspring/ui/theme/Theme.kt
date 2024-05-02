package com.example.wellspring.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColorScheme(
            primary = Color.primaryDark,
            onPrimary = Color.onPrimaryDark,
            primaryContainer = Color.primaryContainerDark,
            onPrimaryContainer = Color.onPrimaryContainerDark,
            secondary = Color.secondaryDark,
            onSecondary = Color.onSecondaryDark,
            secondaryContainer = Color.secondaryContainerDark,
            onSecondaryContainer = Color.onSecondaryContainerDark,
        )
    } else {
        lightColorScheme(
            primary = Color.primary,
            onPrimary = Color.onPrimary,
            primaryContainer = Color.primaryContainer,
            onPrimaryContainer = Color.onPrimaryContainer,
            secondary = Color.secondary,
            onSecondary = Color.onSecondary,
            secondaryContainer = Color.secondaryContainer,
            onSecondaryContainer = Color.onSecondaryContainer
        )
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}

