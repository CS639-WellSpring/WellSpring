package com.example.wellspring.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wellspring.R
import com.example.wellspring.ui.components.MonthPicker
import com.example.wellspring.ui.components.MonthPickerDialog
import com.example.wellspring.ui.data.MoodData
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
import java.time.YearMonth


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChartScreen(navController: NavHostController) {
    var selectedMonth by remember { mutableStateOf(YearMonth.now()) }
    var showMonthPicker by remember { mutableStateOf(false) }

    AppTheme {
        Scaffold(
            topBar = {
                MediumTopAppBar(
                    title = {
                        MonthPicker(selectedMonth, onMonthClick = { showMonthPicker = true })
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
    val moodDataForMonth = MoodData.getRecordsForMonth(selectedMonth)

    ChartContainer(title = "Mood Flow") {
        BarChartComposable()
    }
}

@Composable
fun DoughnutChartWithContainer(selectedMonth: YearMonth) {
    val moodDataForMonth = MoodData.getRecordsForMonth(selectedMonth)

    ChartContainer(title = "Mood Count") {
        DoughnutChartComposable()
    }
}

@Composable
fun BarChartComposable() {
    AndroidView(
        modifier = Modifier.fillMaxWidth().height(280.dp),
        factory = { context ->
            BarChart(context).apply {
                val moodToInt = mapOf(
                    "Excited" to 6,
                    "Happy" to 5,
                    "Peace" to 4,
                    "Bored" to 3,
                    "Worried" to 2,
                    "Sad" to 1
                )
                val entries = MoodData.monthlyMoodRecords.map { record ->
                    BarEntry(record.date.dayOfMonth.toFloat(), moodToInt[record.mood]?.toFloat() ?: 0f)
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
                }
                axisLeft.apply {
                    isEnabled = false

                    setDrawGridLines(false)
                }
                axisRight.apply {
                    isEnabled = false
                }

            }
        }
    )
}


@Composable
fun DoughnutChartComposable() {
    AndroidView(
        modifier = Modifier.fillMaxWidth().height(280.dp),
        factory = { context ->
            PieChart(context).apply {

                val entries = MoodData.monthlyMoodRecords.groupBy { it.mood }.map { (mood, records) ->
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
        }
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewChartScreen() {
    val navController = rememberNavController()
    ChartScreen(navController)
}