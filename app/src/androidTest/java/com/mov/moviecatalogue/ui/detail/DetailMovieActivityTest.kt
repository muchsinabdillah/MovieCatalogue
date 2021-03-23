package com.mov.moviecatalogue.ui.detail
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.mov.moviecatalogue.R
import com.mov.moviecatalogue.ui.home.HomeActivity
import com.mov.moviecatalogue.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class DetailMovieActivityTest   {

    var dummyMovie = DataDummy.generateDummyMovie()

    @get:Rule
    var activityRule = ActivityScenarioRule(DetailMovieActivity::class.java)

    @Test
    fun loadDetailMovie() {
      onView(withId(R.id.text_desc)).check(matches(isDisplayed()))

    }
}