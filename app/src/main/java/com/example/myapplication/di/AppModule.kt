package com.example.myapplication.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by ifucolo on 29/11/17.
 */
@Module
class AppModule(val app: Application){

    @Provides
    @Singleton
    fun providesApplication(): Application {
        return app
    }

    @Provides
    @Singleton
    fun providesContext(): Context {
        return app.applicationContext
    }
}