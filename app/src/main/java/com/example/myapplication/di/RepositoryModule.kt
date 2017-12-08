package com.example.myapplication.di

import com.example.myapplication.source.domain.DataSource
import com.example.myapplication.source.infrastructure.Repository
import dagger.Module
import dagger.Provides

/**
 * Created by ifucolo on 29/11/17.
 */
@Module
class RepositoryModule {

    @Provides
    fun providesSelectSpaceCreateSource(repositoryModule: Repository): DataSource = repositoryModule
}