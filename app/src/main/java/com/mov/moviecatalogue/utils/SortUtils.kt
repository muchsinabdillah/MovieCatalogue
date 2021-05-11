package com.mov.moviecatalogue.utils

import androidx.sqlite.db.SimpleSQLiteQuery


object SortUtils {
    const val VOTE_BEST = "Best"
    const val VOTE_WORST = "Worst"
    const val RANDOM = "Random"
    const val MOVIE_ENTITIES = "Movie"
    const val TV_SHOW_ENTITIES = "TvShow"

    fun getSortedQuery(filter: String, table_name: String): SimpleSQLiteQuery {
        val simpleQuery = StringBuilder().append("SELECT * FROM $table_name ")
        when (filter) {
            VOTE_BEST -> simpleQuery.append("ORDER BY vote_average DESC")
            VOTE_WORST -> simpleQuery.append("ORDER BY vote_average ASC")
            RANDOM -> simpleQuery.append("ORDER BY RANDOM()")
        }
        return SimpleSQLiteQuery(simpleQuery.toString())
    }
}