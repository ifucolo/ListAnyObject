package com.example.myapplication.di

import com.example.myapplication.ListAnyObjectApplication
import dagger.Component
import javax.inject.Singleton

/**
 * Created by ifucolo on 29/11/17.
 */
@Singleton
@Component(modules = [(AppModule::class), (NetModule::class), (RepositoryModule::class)])
interface ApplicationComponent {

    fun inject(listAnyObjectApplication: ListAnyObjectApplication) {}

}