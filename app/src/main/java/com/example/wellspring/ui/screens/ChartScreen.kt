package com.example.wellspring.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wellspring.data.MoodData
import com.example.wellspring.data.MoodRecord
import com.example.wellspring.ui.components.MonthPickerDialog
import com.example.wellspring.ui.theme.AppTheme
import com.example.wellspring.ui.theme.Color.surfaceContainer
import com.example.wellspring.ui.theme.barColor
import com.example.wellspring.ui.theme.moodColorMap
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChartScreen(navController: NavHostController) {
    var selectedMonth by remember { mutableStateOf(YearMonth.now()) }

    AppTheme {
        Scaffold(
            topBar = {
                MediumTopAppBar(
                    title = {
                        MonthPickerRow(
                            selectedMonth = selectedMonth,
                            onMonthChange = { newMonth -> selectedMonth = newMonth }
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                        }
                    }
                )
            },

        ) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                Spacer(modifier = Modifier.height(8.dp))
                BarChartWithContainer(selectedMonth)
                Spacer(modifier = Modifier.height(24.dp))
                DoughnutChartWithContainer(selectedMonth)
            }
        }
    }
}

@Composable
fun MonthPickerRow(selectedMonth: YearMonth, onMonthChange: (YearMonth) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {
            onMonthChange(selectedMonth.minusMonths(1))
        }) {
            Icon(Icons.Filled.KeyboardArrowLeft, contentDescription = "Previous Month")
        }
        LaunchedEffect(selectedMonth) {
            println("Month changed to: $selectedMonth")
        }
        Text(
            text = "${selectedMonth.month.name.lowercase().capitalize()} ${selectedMonth.year}",
            style = MaterialTheme.typography.headlineSmall
        )
        IconButton(onClick = {
            onMonthChange(selectedMonth.plusMonths(1))
        }) {
            Icon(Icons.Filled.KeyboardArrowRight, contentDescription = "Next Month")
        }
    }
}

@Composable
fun ChartContainer(title: String, content: @Composable () -> Unit) {
    Surface(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 0.dp)
            .height(280.dp)
            .fillMaxWidth(),
        color = surfaceContainer,
        shape = RoundedCornerShape(28.03.dp)
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Text(text = title, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(16.dp))
            content()
        }
    }
}

@Composable
fun BarChartWithContainer(selectedMonth: YearMonth) {
    Log.d("ChartDebug", "Recomposing Bar Chart for month: $selectedMonth")
    val moodDataForMonth = MoodData.getRecordsForMonth(selectedMonth)
    ChartContainer(title = "Mood Flow") {
        BarChartComposable(moodDataForMonth)
    }
}

@Composable
fun DoughnutChartWithContainer(selectedMonth: YearMonth) {
    val moodDataForMonth = MoodData.getRecordsForMonth(selectedMonth)
    ChartContainer(title = "Mood Count") {
        DoughnutChartComposable(moodDataForMonth)
    }
}

@Composable
fun BarChartComposable(moodData: List<MoodRecord>) {
    AndroidView(
        modifier = Modifier.fillMaxWidth().height(280.dp),
        factory = { context ->
            BarChart(context).apply {
                val moodToInt = mapOf(
                    "Excited" to 6, "Happy" to 5, "Peace" to 4,
                    "Bored" to 3, "Worried" to 2, "Sad" to 1
                )
                val entries = (1..31).map { day ->
                    val moodLevel = moodData.find { it.date.dayOfMonth == day }?.mood?.let {
                        moodToInt[it]
                    } ?: 0
                    BarEntry(day.toFloat(), moodLevel.toFloat())
                }
                val dataSet = BarDataSet(entries, "").apply {
                    color = barColor.toArgb()
                    valueTextSize = 0f
                }
                data = BarData(dataSet)
                description.isEnabled = false
                legend.isEnabled = false

                xAxis.apply {
                    position = XAxis.XAxisPosition.BOTTOM
                    setDrawGridLines(false)
                    granularity = 1f
                    axisMinimum = 1f
                    axisMaximum = 31f
                    valueFormatter = IndexAxisValueFormatter((1..31).map { it.toString() })
                }
                axisLeft.apply {
                    isEnabled = false

                    setDrawGridLines(false)
                }
                axisRight.apply {
                    isEnabled = false
                }
            }
        },
        update = { chart ->
            val moodToInt = mapOf(
                "Excited" to 6, "Happy" to 5, "Peace" to 4,
                "Bored" to 3, "Worried" to 2, "Sad" to 1
            )
            val entries = (1..31).map { day ->
                val moodLevel = moodData.find { it.date.dayOfMonth == day }?.mood?.let {
                    moodToInt[it]
                } ?: 0
                BarEntry(day.toFloat(), moodLevel.toFloat())
            }
            val dataSet = BarDataSet(entries, "").apply {
                color = barColor.toArgb()
                valueTextSize = 0f
            }
            chart.data = BarData(dataSet)
            chart.notifyDataSetChanged()
            chart.invalidate()
        }
    )
}


@Composable
fun DoughnutChartComposable(moodData: List<MoodRecord>) {
    AndroidView(
        modifier = Modifier.fillMaxWidth().height(280.dp),
        factory = { context ->
            PieChart(context).apply {

                val entries = moodData.groupBy { it.mood }.map { (mood, records) ->
                    PieEntry(records.size.toFloat(), mood)
                }
                val dataSet = PieDataSet(entries, "").apply {
                    colors = entries.map { entry ->
                        moodColorMap[entry.label]?.toArgb() ?: android.graphics.Color.BLACK
                    }.toList()
                    sliceSpace = 3f
                    selectionShift = 5f
                    setDrawValues(false)
                }
                data = PieData(dataSet)
                description.isEnabled = false
                setDrawHoleEnabled(true)
                holeRadius = 50f
                transparentCircleRadius = 55f

                legend.apply {
                    verticalAlignment = Legend.LegendVerticalAlignment.CENTER
                    horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
                    orientation = Legend.LegendOrientation.VERTICAL
                    setDrawInside(false)
                    form = Legend.LegendForm.CIRCLE
                    formSize = 10f
                    textSize = 12f
                    xEntrySpace = 5f
                }
                animateY(1500)
            }
        },
        update = { chart ->
            val entries = moodData.groupBy { it.mood }.map { (mood, records) ->
                PieEntry(records.size.toFloat(), mood)
            }
            val dataSet = PieDataSet(entries, "").apply {
                colors = entries.map { entry ->
                    moodColorMap[entry.label]?.toArgb() ?: android.graphics.Color.BLACK
                }.toList()
                sliceSpace = 3f
                selectionShift = 5f
                setDrawValues(false)
            }
            chart.data = PieData(dataSet)
            chart.notifyDataSetChanged()
            chart.invalidate() // Forces the chart to redraw
        }
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewChartScreen() {
    val navController = rememberNavController()
    ChartScreen(navController)
}