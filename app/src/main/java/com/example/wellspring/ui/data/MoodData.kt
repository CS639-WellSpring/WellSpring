package com.example.wellspring.ui.data

import java.time.LocalDate


data class MoodRecord(val date: LocalDate, val moodLevel: Int)

//Excited=6, Happy=5, Peace=4, Bored=3, Worried=2, Sad=1
object MoodData {
    val monthlyMoodRecords = listOf(
        MoodRecord(LocalDate.of(2024, 4, 1), 6),
        MoodRecord(LocalDate.of(2024, 4, 2), 5),
        MoodRecord(LocalDate.of(2024, 4, 3), 1),
        MoodRecord(LocalDate.of(2024, 4, 4), 4),
        MoodRecord(LocalDate.of(2024, 4, 5), 2),
        MoodRecord(LocalDate.of(2024, 4, 6), 2),
        MoodRecord(LocalDate.of(2024, 4, 7), 2),
        MoodRecord(LocalDate.of(2024, 4, 8), 1),
        MoodRecord(LocalDate.of(2024, 4, 9), 4),
        MoodRecord(LocalDate.of(2024, 4, 10), 4),
        MoodRecord(LocalDate.of(2024, 4, 11), 0),
        MoodRecord(LocalDate.of(2024, 4, 12), 3),
        MoodRecord(LocalDate.of(2024, 4, 13), 3),
        MoodRecord(LocalDate.of(2024, 4, 14), 3),
        MoodRecord(LocalDate.of(2024, 4, 15), 6),
        MoodRecord(LocalDate.of(2024, 4, 16), 5),
        MoodRecord(LocalDate.of(2024, 4, 17), 1),
        MoodRecord(LocalDate.of(2024, 4, 18), 6),
        MoodRecord(LocalDate.of(2024, 4, 19), 2),
        MoodRecord(LocalDate.of(2024, 4, 20), 2),
        MoodRecord(LocalDate.of(2024, 4, 21), 2),
        MoodRecord(LocalDate.of(2024, 4, 22), 3),
        MoodRecord(LocalDate.of(2024, 4, 23), 1),
        MoodRecord(LocalDate.of(2024, 4, 24), 4),
        MoodRecord(LocalDate.of(2024, 4, 25), 2),
        MoodRecord(LocalDate.of(2024, 4, 26), 3),
        MoodRecord(LocalDate.of(2024, 4, 27), 2),
        MoodRecord(LocalDate.of(2024, 4, 28), 3),
    )
}
