package com.mov.moviecatalogue.di

import android.content.Context
import com.mov.moviecatalogue.data.source.CatalogueRepository
import com.mov.moviecatalogue.data.source.local.LocalRepository
import com.mov.moviecatalogue.data.source.remote.RemoteRepository
import com.mov.moviecatalogue.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): CatalogueRepository {
        val remoteRepository = RemoteRepository.getInstance()
        val localRepository = LocalRepository.getInstance(context)
        val appExecutors = AppExecutors()
        return CatalogueRepository.getInstance(remoteRepository, localRepository, appExecutors)
    }
}