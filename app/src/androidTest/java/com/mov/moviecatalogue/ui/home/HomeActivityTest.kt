package com.mov.moviecatalogue.ui.home

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.mov.moviecatalogue.R
import com.mov.moviecatalogue.data.MovieEntity
import com.mov.moviecatalogue.ui.detail.DetailMovieActivity
import com.mov.moviecatalogue.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {
    private val dummyMovie = DataDummy.generateDummyMovie()
    private val dummyTvShow = DataDummy.generateDummyTvShow()
    @get:Rule
    var activityRule: ActivityTestRule<HomeActivity> =
        object : ActivityTestRule<HomeActivity>(HomeActivity::class.java) {

            override fun getActivityIntent(): Intent {
                val targetContext = InstrumentationRegistry.getInstrumentation().targetContext
                val result = Intent(targetContext, DetailMovieActivity::class.java)
                //val datamovie = MovieEntity(movie.movieId,movie.title,movie.genre,movie.headline,movie.overview,movie.imagePath)
                //result.putExtra(DetailMovieActivity.EXTRA_TVSHOW, datamovie)



                return result
            }
        }

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }
    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.text_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.text_genre)).check(matches(withText(dummyMovie[0].genre)))
        onView(withId(R.id.text_headline)).check(matches(isDisplayed()))
        onView(withId(R.id.text_headline)).check(matches(withText(dummyMovie[0].headline)))
        onView(withId(R.id.text_genre)).check(matches(isDisplayed()))
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
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.text_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.text_genre)).check(matches(withText(dummyTvShow[0].genre)))
        onView(withId(R.id.text_headline)).check(matches(isDisplayed()))
        onView(withId(R.id.text_headline)).check(matches(withText(dummyTvShow[0].headline)))
        onView(withId(R.id.text_genre)).check(matches(isDisplayed()))
    }

}