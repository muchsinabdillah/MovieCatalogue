package com.mov.moviecatalogue.di

import android.content.Context
import com.mov.moviecatalogue.data.source.CatalogueRepository
import com.mov.moviecatalogue.data.source.remote.RemoteRepository

object Injection {
    fun provideRepository(context: Context): CatalogueRepository {
        val remoteRepository = RemoteRepository.getInstance()
        return CatalogueRepository.getInstance(remoteRepository)
    }
}