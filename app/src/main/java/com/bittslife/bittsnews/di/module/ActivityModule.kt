package com.bittslife.bittsnews.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bittslife.bittsnews.data.repository.NewsRepository
import com.bittslife.bittsnews.di.ActivityContext
import com.bittslife.bittsnews.ui.activity.NewsViewModel
import com.bittslife.bittsnews.ui.adapter.NewsAdapter
import com.bittslife.bittsnews.ui.base.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideNewsViewModel(newsRepository: NewsRepository): NewsViewModel {
        return ViewModelProvider(activity,
            ViewModelProviderFactory(NewsViewModel::class) {
                NewsViewModel(newsRepository)
            })[NewsViewModel::class.java]
    }

    @Provides
    fun provideNewsAdapter() = NewsAdapter(kotlin.collections.ArrayList())

}