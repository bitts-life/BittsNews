package com.bittslife.bittsnews

import android.app.Application
import com.bittslife.bittsnews.di.component.ApplicationComponent
import com.bittslife.bittsnews.di.module.ApplicationModule
import com.bittslife.bittsnews.di.component.DaggerApplicationComponent

class NewsApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}