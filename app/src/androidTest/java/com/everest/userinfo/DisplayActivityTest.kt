package com.everest.userinfo


import androidx.test.espresso.Espresso.*

import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches

import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.text.IsEqualIgnoringCase
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DisplayActivityTest{
    @get:Rule
    val activityRule = ActivityScenarioRule(DisplayActivity::class.java)

    @Test
    fun shouldDisplayConfirmedText() {
        onView(withId(R.id.resultTV)).check(matches(withText("Hi "+"yashu, How are you? Are you staying at 17/992/1" +
                    " venugopalnagar oldtown anantapur-515001 " +
                    "code. I am not able to contact you on 9182985817. Can I " +
                    "email you the details at yashu@gmail.com ")))


    }


}

