package com.dicoding.tourismapp

import android.app.Application
import com.dicoding.tourismapp.core.di.CoreComponent
import com.dicoding.tourismapp.core.di.DaggerCoreComponent
import com.dicoding.tourismapp.core.di.databaseModule
import com.dicoding.tourismapp.core.di.networkModule
import com.dicoding.tourismapp.core.di.repositoryModule
import com.dicoding.tourismapp.di.AppComponent
import com.dicoding.tourismapp.di.DaggerAppComponent
import com.dicoding.tourismapp.di.useCaseModule
import com.dicoding.tourismapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }

    }
    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }
}