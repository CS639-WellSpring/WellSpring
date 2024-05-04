package com.example.wellspring.data

import java.time.LocalDate
import java.time.YearMonth

data class MoodRecord(val date: LocalDate, val mood: String)

object MoodData {
    private val _monthlyMoodRecords = mutableListOf(
        MoodRecord(LocalDate.of(2024, 3, 1), "Excited"),
        MoodRecord(LocalDate.of(2024, 3, 2), "Happy"),
        MoodRecord(LocalDate.of(2024, 3, 3), "Sad"),
        MoodRecord(LocalDate.of(2024, 3, 4), "Peace"),
        MoodRecord(LocalDate.of(2024, 3, 6), "Worried"),
        MoodRecord(LocalDate.of(2024, 3, 7), "Worried"),
        MoodRecord(LocalDate.of(2024, 3, 8), "Happy"),
        MoodRecord(LocalDate.of(2024, 3, 9), "Peace"),
        MoodRecord(LocalDate.of(2024, 3, 10), "Peace"),
        MoodRecord(LocalDate.of(2024, 3, 12), "Bored"),
        MoodRecord(LocalDate.of(2024, 3, 13), "Bored"),
        MoodRecord(LocalDate.of(2024, 3, 14), "Bored"),
        MoodRecord(LocalDate.of(2024, 3, 15), "Excited"),
        MoodRecord(LocalDate.of(2024, 3, 16), "Happy"),
        MoodRecord(LocalDate.of(2024, 3, 17), "Sad"),
        MoodRecord(LocalDate.of(2024, 3, 19), "Worried"),
        MoodRecord(LocalDate.of(2024, 3, 20), "Worried"),
        MoodRecord(LocalDate.of(2024, 3, 22), "Bored"),

        MoodRecord(LocalDate.of(2024, 4, 1), "Excited"),
        MoodRecord(LocalDate.of(2024, 4, 2), "Happy"),
        MoodRecord(LocalDate.of(2024, 4, 3), "Sad"),
        MoodRecord(LocalDate.of(2024, 4, 4), "Peace"),
        MoodRecord(LocalDate.of(2024, 4, 6), "Worried"),
        MoodRecord(LocalDate.of(2024, 4, 7), "Worried"),
        MoodRecord(LocalDate.of(2024, 4, 8), "Happy"),
        MoodRecord(LocalDate.of(2024, 4, 9), "Peace"),
        MoodRecord(LocalDate.of(2024, 4, 10), "Peace"),
        MoodRecord(LocalDate.of(2024, 4, 12), "Bored"),
        MoodRecord(LocalDate.of(2024, 4, 13), "Bored"),
        MoodRecord(LocalDate.of(2024, 4, 14), "Bored"),
        MoodRecord(LocalDate.of(2024, 4, 15), "Excited"),
        MoodRecord(LocalDate.of(2024, 4, 16), "Peace"),
        MoodRecord(LocalDate.of(2024, 4, 17), "Happy"),
        MoodRecord(LocalDate.of(2024, 4, 19), "Worried"),
        MoodRecord(LocalDate.of(2024, 4, 20), "Worried"),
        MoodRecord(LocalDate.of(2024, 4, 22), "Bored"),
        MoodRecord(LocalDate.of(2024, 4, 23), "Sad"),
        MoodRecord(LocalDate.of(2024, 4, 24), "Peace"),
        MoodRecord(LocalDate.of(2024, 4, 25), "Worried"),
        MoodRecord(LocalDate.of(2024, 4, 26), "Sad"),
        MoodRecord(LocalDate.of(2024, 4, 27), "Worried"),
        MoodRecord(LocalDate.of(2024, 4, 28), "Excited"),
        MoodRecord(LocalDate.of(2024, 4, 29), "Happy"),

        MoodRecord(LocalDate.of(2024, 5, 1), "Worried"),
        MoodRecord(LocalDate.of(2024, 5, 2), "Happy"),
        MoodRecord(LocalDate.of(2024, 5, 3), "Worried"),
    )
    val monthlyMoodRecords: List<MoodRecord>
        get() = _monthlyMoodRecords.toList()

    fun getMood(date: LocalDate): MoodRecord? {
        return _monthlyMoodRecords.find { it.date == date }
    }
    fun getMoodForDate(date: LocalDate): String? {
        return monthlyMoodRecords.find { it.date == date }?.mood
    }
    fun getRecordsForMonth(yearMonth: YearMonth): List<MoodRecord> {
        val data = _monthlyMoodRecords.filter { YearMonth.from(it.date) == yearMonth }
        println("Fetched ${data.size} records for $yearMonth")
        return data
    }

    fun addMoodRecord(record: MoodRecord) {
        if (isValidRecord(record)) {
            _monthlyMoodRecords.add(record)
            println("Mood record added: ${record.mood} on ${record.date}")
        } else {
            println("Invalid mood record: ${record.mood} on ${record.date}")
        }
    }

    private fun isValidRecord(record: MoodRecord): Boolean {
        // Example validation: the mood is non-empty and the date is not in the future
        return record.mood.isNotEmpty() && !record.date.isAfter(LocalDate.now())
    }
}
