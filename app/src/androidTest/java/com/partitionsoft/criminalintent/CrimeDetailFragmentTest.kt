package com.partitionsoft.criminalintent

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import java.util.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CrimeDetailFragmentTest {

    @Test
    fun crimeTitleEditText_updatesCrimeTitle() {
        // Create a new Crime object
        val crime = Crime(
            id = UUID.randomUUID(),
            title = "",
            date = Date(),
            isSolved = false
        )

        // Create a new FragmentScenario for the CrimeDetailFragment
        val scenario = launchFragmentInContainer<CrimeDetailFragment>()

        // Use onFragment to get access to the CrimeDetailFragment
        scenario.onFragment { fragment ->
            // Set the Crime object in the fragment
            fragment.crime = crime

            // Find the crimeTitle EditText and enter some text
            val titleEditText = fragment.binding.crimeTitle
            titleEditText.setText("Test Crime Title")

            // Assert that the Crime object's title was updated
            assertEquals("Test Crime Title", fragment.crime.title)
        }
    }

    @Test
    fun crimeSolvedCheckBox_updatesCrimeSolved() {
        // Create a new Crime object
        val crime = Crime(
            id = UUID.randomUUID(),
            title = "",
            date = Date(),
            isSolved = false
        )

        // Create a new FragmentScenario for the CrimeDetailFragment
        val scenario = launchFragmentInContainer<CrimeDetailFragment>()

        // Use onFragment to get access to the CrimeDetailFragment
        scenario.onFragment { fragment ->
            // Set the Crime object in the fragment
            fragment.crime = crime

            // Find the crimeSolved CheckBox and check it
            val solvedCheckBox = fragment.binding.crimeSolved
            solvedCheckBox.isChecked = true

            // Assert that the Crime object's solved status was updated
            assertTrue(fragment.crime.isSolved)
        }
    }
}