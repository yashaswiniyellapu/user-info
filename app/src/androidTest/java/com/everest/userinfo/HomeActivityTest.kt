package com.everest.userinfo


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches

import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class HomeActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.everest.userinfo", appContext.packageName)
    }

    @Test
    fun shouldDisplayTextWhenValidateIsClicked() {
        onView(withId(R.id.input_user_name)).perform(typeText("yashu"))
        onView(withId(R.id.input_email)).perform(typeText("yashu@gmail.com"))
        onView(withId(R.id.input_ph)).perform(typeText("9182985817"))
        onView(withId(R.id.input_pin_code)).perform(typeText("515001"))
        onView(withId(R.id.input_address)).perform(typeText("17/992/1 venugopalnagar oldtown anantapur"))

        onView(withText(equalToIgnoringCase("validate"))).perform(scrollTo(),click())

        onView(withId(R.id.dis_username_TV)).check(matches(withText("yashu")))
        onView(withId(R.id.dis_emailTV)).check(matches(withText("yashu@gmail.com")))
        onView(withId(R.id.dis_phone_number_TV)).check(matches(withText("9182985817")))
        onView(withId(R.id.dis_pin_code_TV)).check(matches(withText("515001")))
        onView(withId(R.id.dis_address_TV)).check(matches(withText("17/992/1 venugopalnagar oldtown anantapur")))
    }

    @Test
    fun shouldReturnInputFieldsOnClickingCancelButton()
    {
        onView(withId(R.id.input_user_name)).perform(typeText("yashu"))
        onView(withId(R.id.input_email)).perform(typeText("yashu@gmail.com"))
        onView(withId(R.id.input_ph)).perform(typeText("9182985817"))
        onView(withId(R.id.input_pin_code)).perform(typeText("515001"))
        onView(withId(R.id.input_address)).perform(typeText("17/992/1 venugopalnagar oldtown anantapur"))

        onView(withText(equalToIgnoringCase("validate"))).perform(scrollTo(),click())

        onView(withId(R.id.displayTV)).check(matches(isDisplayed()))
        onView(withId(R.id.inputTV)).check(matches(isNotFocused()))

        onView(withText(equalToIgnoringCase("cancel"))).perform(click())

        onView(withId(R.id.inputTV)).check(matches(isDisplayed()))
        onView(withId(R.id.displayTV)).check(matches(isNotFocused()))
    }


}

