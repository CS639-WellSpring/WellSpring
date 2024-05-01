package com.example.wellspring.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.wellspring.ui.data.MoodData
import com.example.wellspring.ui.theme.AppTheme
import com.example.wellspring.ui.theme.bar
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChartScreen(navController: NavHostController) {

    AppTheme {
        Scaffold(
            topBar = {
                MediumTopAppBar(
                    title = { Text("Chart", style = MaterialTheme.typography.headlineLarge) },
                    actions = {
                        IconButton(onClick = { /* TODO: Handle profile click */ }) {
                            Icon(Icons.Filled.AccountCircle, contentDescription = "Profile")
                        }
                    }
                )
            },
            bottomBar = {
                ChartBottomNavigationBar(navController)
            }
        ) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                BarChartComposable()
                Spacer(modifier = Modifier.height(16.dp))
                /*DoughnutChartComposable()*/
            }
        }
    }
}

@Composable
fun BarChartComposable() {
    AndroidView(
        modifier = Modifier.fillMaxWidth().height(250.dp),
        factory = { context ->
            BarChart(context).apply {
                val entries = MoodData.monthlyMoodRecords.map { record ->
                    BarEntry(record.date.dayOfMonth.toFloat(), record.moodLevel.toFloat())
                }
                val dataSet = BarDataSet(entries, "").apply {
                    color = bar.toArgb()
                    valueTextSize = 0f
                    form = Legend.LegendForm.CIRCLE

                }
                data = BarData(dataSet)
                description.isEnabled = false
                legend.isEnabled = false

                xAxis.apply {
                    position = XAxis.XAxisPosition.BOTTOM
                    granularity = 1f
                    valueFormatter = IndexAxisValueFormatter((1..31).map { it.toString() })
                    setDrawGridLines(false)
                }

                axisLeft.apply {
                    granularity = 1f
                    axisMinimum = 0f
                    axisMaximum = 6f 
                    setDrawGridLines(true)
                    setDrawLabels(false)
                }
                axisRight.isEnabled = false
                animateY(1500)
            }
        }
    )
}

/*
@Composable
fun DoughnutChartComposable() {
    AndroidView(factory = { context ->
        PieChart(context).apply {
            val entries = MoodData.monthlyMoodRecords.groupBy { it.mood }.map { (mood, records) ->
                PieEntry(records.size.toFloat(), moodLevel)
            }
            val dataSet = PieDataSet(entries, "Mood Distribution").apply {
                setColors(*ColorTemplate.JOYFUL_COLORS)
                sliceSpace = 3f
                selectionShift = 5f
            }
            data = PieData(dataSet)
            description.isEnabled = false
            setDrawHoleEnabled(true)
            holeRadius = 28f
            transparentCircleRadius = 31f
            animateY(1500)
        }
    }, modifier = Modifier.fillMaxWidth().height(250.dp))
}*/

@Composable
fun ChartBottomNavigationBar(navController: NavHostController) {
    val context = LocalContext.current
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.ic_events_outline), contentDescription = "Events") },
            label = { Text("Events") },
            selected = false,
            onClick = { navController.navigate("events") }
        )
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.ic_mood_outline), contentDescription = "Mood") },
            label = { Text("Mood") },
            selected = false,
            onClick = { navController.navigate("mood") }
        )
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.ic_chart_filled), contentDescription = "Chart") },
            label = { Text("Chart") },
            selected = true,
            onClick = { /* Handle Chart click */ }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewChartScreen() {
    val navController = rememberNavController()
    ChartScreen(navController)
}