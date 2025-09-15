package com.bittslife.bittsnews.di.component

import android.content.Context
import com.bittslife.bittsnews.NewsApplication
import com.bittslife.bittsnews.data.api.NetworkService
import com.bittslife.bittsnews.data.repository.NewsRepository
import com.bittslife.bittsnews.di.ApplicationContext
import com.bittslife.bittsnews.di.module.ApplicationModule
import com.bittslife.bittsnews.ui.activity.NewsActivity
import dagger.Component
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: NewsApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getNewsRepository(): NewsRepository
}