package com.example.wellspring.ui.data

import java.time.LocalDate
import java.time.YearMonth

data class MoodRecord(val date: LocalDate, val mood: String)

object MoodData {
    private val _monthlyMoodRecords = mutableListOf(
        MoodRecord(LocalDate.of(2024, 3, 1), "excited"),
        MoodRecord(LocalDate.of(2024, 3, 2), "happy"),
        MoodRecord(LocalDate.of(2024, 3, 3), "sad"),
        MoodRecord(LocalDate.of(2024, 3, 4), "peace"),
        MoodRecord(LocalDate.of(2024, 3, 6), "worried"),
        MoodRecord(LocalDate.of(2024, 3, 7), "worried"),
        MoodRecord(LocalDate.of(2024, 3, 8), "happy"),
        MoodRecord(LocalDate.of(2024, 3, 9), "peace"),
        MoodRecord(LocalDate.of(2024, 3, 10), "peace"),
        MoodRecord(LocalDate.of(2024, 3, 12), "bored"),
        MoodRecord(LocalDate.of(2024, 3, 13), "bored"),
        MoodRecord(LocalDate.of(2024, 3, 14), "bored"),
        MoodRecord(LocalDate.of(2024, 3, 15), "excited"),
        MoodRecord(LocalDate.of(2024, 3, 16), "happy"),
        MoodRecord(LocalDate.of(2024, 3, 17), "sad"),
        MoodRecord(LocalDate.of(2024, 3, 19), "worried"),
        MoodRecord(LocalDate.of(2024, 3, 20), "worried"),
        MoodRecord(LocalDate.of(2024, 3, 22), "bored"),

        MoodRecord(LocalDate.of(2024, 4, 1), "excited"),
        MoodRecord(LocalDate.of(2024, 4, 2), "happy"),
        MoodRecord(LocalDate.of(2024, 4, 3), "sad"),
        MoodRecord(LocalDate.of(2024, 4, 4), "peace"),
        MoodRecord(LocalDate.of(2024, 4, 6), "worried"),
        MoodRecord(LocalDate.of(2024, 4, 7), "worried"),
        MoodRecord(LocalDate.of(2024, 4, 8), "happy"),
        MoodRecord(LocalDate.of(2024, 4, 9), "peace"),
        MoodRecord(LocalDate.of(2024, 4, 10), "peace"),
        MoodRecord(LocalDate.of(2024, 4, 12), "bored"),
        MoodRecord(LocalDate.of(2024, 4, 13), "bored"),
        MoodRecord(LocalDate.of(2024, 4, 14), "bored"),
        MoodRecord(LocalDate.of(2024, 4, 15), "excited"),
        MoodRecord(LocalDate.of(2024, 4, 16), "happy"),
        MoodRecord(LocalDate.of(2024, 4, 17), "sad"),
        MoodRecord(LocalDate.of(2024, 4, 19), "worried"),
        MoodRecord(LocalDate.of(2024, 4, 20), "worried"),
        MoodRecord(LocalDate.of(2024, 4, 22), "bored"),
        MoodRecord(LocalDate.of(2024, 4, 23), "sad"),
        MoodRecord(LocalDate.of(2024, 4, 24), "peace"),
        MoodRecord(LocalDate.of(2024, 4, 25), "worried"),
        MoodRecord(LocalDate.of(2024, 4, 27), "worried"),
        MoodRecord(LocalDate.of(2024, 4, 28), "bored"),
    )
    val monthlyMoodRecords: List<MoodRecord>
        get() = _monthlyMoodRecords.toList()

    fun addMoodRecord(record: MoodRecord) {
        if (isValidRecord(record)) {
            _monthlyMoodRecords.add(record)
        }
    }
    fun getRecordsForMonth(yearMonth: YearMonth): List<MoodRecord> {
        return _monthlyMoodRecords.filter {
            YearMonth.from(it.date) == yearMonth
        }
    }
    private fun isValidRecord(record: MoodRecord): Boolean {
        return record.mood.isNotEmpty() && record.date.isBefore(LocalDate.now().plusDays(1))
    }
}
