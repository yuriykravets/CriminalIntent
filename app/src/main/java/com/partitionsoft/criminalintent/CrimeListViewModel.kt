package com.partitionsoft.criminalintent

import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class CrimeListViewModel : ViewModel() {
    val crimes = mutableListOf<Crime>()

    init {
        val dateFormat = SimpleDateFormat("EEEE, MMM d, yyyy", Locale.getDefault())
        val currentDate = Date()
        val formattedDate = dateFormat.format(currentDate)

        for (i in 0 until 100) {
            val crime = Crime(
                id = UUID.randomUUID(),
                title = "Crime #$i",
                date = formattedDate,
                isSolved = i % 2 == 0, requiresPolicy = i % 3 == 0
            )
            crimes += crime
        }
    }
}
