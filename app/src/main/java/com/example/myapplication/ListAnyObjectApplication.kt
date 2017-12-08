package com.example.myapplication

import android.app.Application
import com.example.myapplication.di.AppModule
import com.example.myapplication.di.ApplicationComponent
import com.example.myapplication.di.DaggerApplicationComponent
import com.facebook.stetho.Stetho

/**
 * Created by ifucolo on 29/11/17.
 */
class ListAnyObjectApplication: Application() {

    val instance : ListAnyObjectApplication = this

    companion object {
        lateinit var mApplicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        mApplicationComponent = DaggerApplicationComponent.builder()
                .appModule(AppModule(this))
                .build()

        mApplicationComponent.inject(this)


        if(BuildConfig.DEBUG){
            Stetho.initializeWithDefaults(this)

            Stetho.initialize(
                    Stetho.newInitializerBuilder(this)
                            .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                            .build())
        }
    }

    fun get(): ListAnyObjectApplication {
        return instance
    }

    fun getCoreComponent(): ApplicationComponent {
        return mApplicationComponent
    }

}