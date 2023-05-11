package com.partitionsoft.criminalintent

import java.util.*

data class Crime(
    val id: UUID,
    val title: String,
    val date: String,
    val isSolved: Boolean,
    val requiresPolicy: Boolean
)
