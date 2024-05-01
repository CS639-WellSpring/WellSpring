package com.example.wellspring.ui.data

import java.time.LocalDate

enum class MoodType {
    Excited, Happy, Peace, Bored, Worried, Sad
}

data class MoodRecord(
    val date: LocalDate,
    val mood: MoodType
)

object MoodData {
    val monthlyMoodRecords = listOf(
        MoodRecord(LocalDate.of(2024, 4, 1), MoodType.Happy),
        MoodRecord(LocalDate.of(2024, 4, 2), MoodType.Peace),
        MoodRecord(LocalDate.of(2024, 4, 3), MoodType.Worried),
        MoodRecord(LocalDate.of(2024, 4, 4), MoodType.Excited),
        MoodRecord(LocalDate.of(2024, 4, 5), MoodType.Bored),
        MoodRecord(LocalDate.of(2024, 4, 6), MoodType.Sad),
        MoodRecord(LocalDate.of(2024, 4, 7), MoodType.Bored),
        MoodRecord(LocalDate.of(2024, 4, 8), MoodType.Bored),
        MoodRecord(LocalDate.of(2024, 4, 9), MoodType.Excited),
        MoodRecord(LocalDate.of(2024, 4, 10), MoodType.Peace),
        MoodRecord(LocalDate.of(2024, 4, 11), MoodType.Peace),
        MoodRecord(LocalDate.of(2024, 4, 12), MoodType.Peace),
        MoodRecord(LocalDate.of(2024, 4, 13), MoodType.Happy),
    )
}
