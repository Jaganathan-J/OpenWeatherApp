package com.jagan.openweatherapp

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jagan.openweatherapp.ui.main.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val composeTestRule = createComposeRule() // Compose test rule

    @Test
    fun testUseMyLocationButtonClick() {
        // Set content for the test
        composeTestRule.setContent {
            MainActivity()
        }

        // Verify that "Use My Location" button is displayed and click it
        composeTestRule.onNodeWithTag("useMyLocationButton").assertExists().performClick()

        // After clicking, check that Toast message is displayed (Note: Toast checking is tricky in Compose)
    }
}
