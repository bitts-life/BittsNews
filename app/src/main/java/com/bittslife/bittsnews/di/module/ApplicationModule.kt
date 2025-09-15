package com.bittslife.bittsnews.di.module

import android.content.Context
import com.bittslife.bittsnews.NewsApplication
import com.bittslife.bittsnews.data.api.NetworkService
import com.bittslife.bittsnews.di.ApplicationContext
import com.bittslife.bittsnews.di.BaseUrl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(private val newsApplication: NewsApplication) {

    @ApplicationContext
    @Provides
    fun provideContext(): Context {
        return newsApplication
    }

    @BaseUrl
    @Provides
    fun provideBaseUrl(): String = "https://newsdata.io/api/1/"

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideNetworkService(
        @BaseUrl baseUrl: String,
        gsonConverterFactory: GsonConverterFactory
    ): NetworkService {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(gsonConverterFactory)
            .build()
            .create(NetworkService::class.java)
    }

}