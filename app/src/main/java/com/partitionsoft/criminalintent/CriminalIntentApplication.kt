package com.partitionsoft.criminalintent

import android.app.Application
import com.partitionsoft.criminalintent.repository.CrimeRepository

class CriminalIntentApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        CrimeRepository.initialize(this)
    }
}