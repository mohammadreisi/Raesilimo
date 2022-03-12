package com.example.raesilimo.ui.movies_list

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.raesilimo.R
import com.example.raesilimo.ui.MainActivity
import org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ListMoviesFragmentTest {

    @Test
    fun isFragmentDisplay(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.fragment_list_movie)).check(matches(isDisplayed()))
    }

    @Test
    fun setMMoviesRecyclerView() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main_activity)).check(matches(isDisplayed()))
    }

    @Test
    fun clickOnListRow() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.row_movie_cover)).perform(click())
        onView(withId(R.id.fragment_detail_movie)).check(matches(isDisplayed()))

    }

    @Test
    fun setMovieResponse() {
    }
}