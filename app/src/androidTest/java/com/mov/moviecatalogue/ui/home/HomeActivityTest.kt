package com.mov.moviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.mov.moviecatalogue.R
import com.mov.moviecatalogue.utils.DataDummy
import com.mov.moviecatalogue.utils.EspressoIdlingResource
import org.hamcrest.core.AllOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {
    var dummyMovie = DataDummy.genMovie()
    var dummyTvShow = DataDummy.genTv()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun LoadMovie() {
        onView(withId(R.id.bottom_nav_main)).check(matches(isDisplayed()))
        onView(
            AllOf.allOf(
                withText("Movie"),
                isDescendantOfA(withId(R.id.bottom_nav_main)),
                isDisplayed()
            )
        ).perform(click())
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun LoadMovieDetail() {
        onView(withId(R.id.bottom_nav_main)).check(matches(isDisplayed()))
        onView(
            AllOf.allOf(
                withText("Movie"),
                isDescendantOfA(withId(R.id.bottom_nav_main)),
                isDisplayed()
            )
        ).perform(click())
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.image_backdrop)).check(matches(isDisplayed()))
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
    }

    @Test
    fun LoadTvShow() {
        onView(withId(R.id.bottom_nav_main)).check(matches(isDisplayed()))
        onView(
            AllOf.allOf(
                withText("Tv Show"),
                isDescendantOfA(withId(R.id.bottom_nav_main)),
                isDisplayed()
            )
        ).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTvShow.size
            )
        )
    }

    @Test
    fun LoadTvShowDetail() {
        onView(withId(R.id.bottom_nav_main)).check(matches(isDisplayed()))
        onView(
            AllOf.allOf(
                withText("Tv Show"),
                isDescendantOfA(withId(R.id.bottom_nav_main)),
                isDisplayed()
            )
        ).perform(click())
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
        onView(withId(R.id.tvdetil_ratingBar)).check(matches(isDisplayed()))
        onView(withId(R.id.tvdetil_text_release_movie)).check(matches(isDisplayed()))
    }

    @Test
    fun LoadFavoriteMovies() {
        onView(withId(R.id.bottom_nav_main)).check(matches(isDisplayed()))
        onView(
            AllOf.allOf(
                withText("Favorite"),
                isDescendantOfA(withId(R.id.bottom_nav_main)),
                isDisplayed()
            )
        ).perform(click())
        onView(withId(R.id.rv_movie_fav)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie_fav)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun LoadFavoriteTvShows() {
        onView(withId(R.id.bottom_nav_main)).check(matches(isDisplayed()))
        onView(
            AllOf.allOf(
                withText("Favorite"),
                isDescendantOfA(withId(R.id.bottom_nav_main)),
                isDisplayed()
            )
        ).perform(click())
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tvshow_fav)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow_fav)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun loadFavoriteTvShowsDetail() {
        onView(withId(R.id.bottom_nav_main)).check(matches(isDisplayed()))
        onView(
            AllOf.allOf(
                withText("Favorite"),
                isDescendantOfA(withId(R.id.bottom_nav_main)),
                isDisplayed()
            )
        ).perform(click())
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tvshow_fav)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow_fav)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tvdetil_image_backdrop)).check(matches(isDisplayed()))
        onView(withId(R.id.tvdetil_image_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tvdetil_text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tvdetil_ratingBar)).check(matches(isDisplayed()))
        onView(withId(R.id.tvdetil_text_release_movie)).check(matches(isDisplayed()))
    }

    @Test
    fun loadFavoriteMoviesDetail() {
        onView(withId(R.id.bottom_nav_main)).check(matches(isDisplayed()))
        onView(
            AllOf.allOf(
                withText("Favorite"),
                isDescendantOfA(withId(R.id.bottom_nav_main)),
                isDisplayed()
            )
        ).perform(click())
        onView(withText("MOVIE")).perform(click())
        onView(withId(R.id.rv_movie_fav)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie_fav)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.image_backdrop)).check(matches(isDisplayed()))
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.ratingBar)).check(matches(isDisplayed()))
        onView(withId(R.id.text_release_movie)).check(matches(isDisplayed()))
    }
}