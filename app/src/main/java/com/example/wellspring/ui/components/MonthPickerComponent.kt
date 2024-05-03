package com.example.wellspring.ui.components

import android.app.DatePickerDialog
import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.util.Calendar

@Composable
fun MonthPicker(
    selectedMonth: YearMonth,
    onMonthClick: () -> Unit
) {
    Row(modifier = Modifier.clickable(onClick = onMonthClick)) {
        Text(
            text = selectedMonth.format(DateTimeFormatter.ofPattern("MMMM yyyy")),
            style = androidx.compose.material3.MaterialTheme.typography.titleLarge
        )
        Icon(
            imageVector = Icons.Default.ArrowDropDown,
            contentDescription = "Select Month"
        )
    }
}

@Composable
fun MonthPickerDialog(
    currentMonth: YearMonth,
    onMonthSelected: (YearMonth) -> Unit,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current
    ShowDatePickerDialog(context, currentMonth, onMonthSelected, onDismiss)
}

@Composable
fun ShowDatePickerDialog(
    context: Context,
    currentMonth: YearMonth,
    onMonthSelected: (YearMonth) -> Unit,
    onDismiss: () -> Unit
) {
    // We use remember to prevent opening the dialog multiple times on recompositions
    val showDialog = remember { mutableStateOf(true) }

    if (showDialog.value) {
        val calendar = Calendar.getInstance().apply {
            set(Calendar.YEAR, currentMonth.year)
            set(Calendar.MONTH, currentMonth.monthValue - 1)
        }

        val datePickerDialog = DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                val selectedDate = YearMonth.of(year, month + 1)
                onMonthSelected(selectedDate)
                showDialog.value = false
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        datePickerDialog.setOnDismissListener {
            onDismiss()
            showDialog.value = false
        }

        datePickerDialog.show()
    }
}
