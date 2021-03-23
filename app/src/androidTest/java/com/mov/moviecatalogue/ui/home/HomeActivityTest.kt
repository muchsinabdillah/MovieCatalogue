package com.mov.moviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.mov.moviecatalogue.R
import com.mov.moviecatalogue.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {
    private val dummyMovie = DataDummy.generateRemoteDummyMovies()
    private val dummyTvShow = DataDummy.generateRemoteDummyTvShow()
    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)


    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }
    @Test
    fun loadDetailMovie() {
        onView(withText("MOVIE")).perform(click())
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.image_backdrop)).check(matches(isDisplayed()))
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(withText(dummyMovie[0].title)))
    }
    @Test
    fun loadTvShow() {
        onView(withText("TVSHOW")).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }
    @Test
    fun loadDetailTvShow() {
        onView(withText("TVSHOW")).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                        0,
                        click()
                )
        )
        onView(withId(R.id.tvdetil_image_backdrop)).check(matches(isDisplayed()))
        onView(withId(R.id.tvdetil_image_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tvdetil_text_title)).check(matches(isDisplayed()))

        onView(withId(R.id.tvdetil_text_title)).check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.tvdetil_ratingBar)).check(matches(isDisplayed()))
        onView(withId(R.id.tvdetil_text_release_movie)).check(matches(isDisplayed()))
    }

}