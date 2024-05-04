package com.example.wellspring.data

import java.time.LocalDate

data class JournalEntry(val date: LocalDate, var text: String)

object JournalData {
    private val entries = mutableListOf(
        JournalEntry(LocalDate.of(2024, 4, 16), "I want to watch new movie Dune: Part Two!"),
        JournalEntry(LocalDate.of(2024, 4, 17), "Went to the park today with Sheron."),
        JournalEntry(LocalDate.of(2024, 4, 18), "Need to clean the room."),
        JournalEntry(LocalDate.of(2024, 4, 20), "Bought new clothes!"),
        JournalEntry(LocalDate.of(2024, 4, 21), "I like this Milk Tea"),
        JournalEntry(LocalDate.of(2024, 4, 24), "Got good grade in class."),
        JournalEntry(LocalDate.of(2024, 4, 26), "Too much work need to do. Sad."),
        JournalEntry(LocalDate.of(2024, 4, 27), "Next week is the final."),
        JournalEntry(LocalDate.of(2024, 4, 28), "Went shopping!"),
        JournalEntry(LocalDate.of(2024, 4, 29), "It's a sunny day!"),
        JournalEntry(LocalDate.of(2024, 5, 1), "Too much work to do."),
        JournalEntry(LocalDate.of(2024, 5, 2), "Walking the cats today! New York 's spring is so short!"),
        JournalEntry(LocalDate.of(2024, 5, 3), "I don't like get up early.")
    )

    fun addOrUpdateEntry(entry: JournalEntry) {
        if (isValidEntry(entry)) {
            val existing = entries.find { it.date == entry.date }
            if (existing != null) {
                existing.text = entry.text
            } else {
                entries.add(entry)
            }
        } else {
            println("Invalid journal entry: ${entry.text} on ${entry.date}")
        }
    }

    fun getAllEntries(): List<JournalEntry> = entries.toList()

    private fun isValidEntry(entry: JournalEntry): Boolean {
        return entry.text.isNotEmpty() && !entry.date.isAfter(LocalDate.now())
    }
}

