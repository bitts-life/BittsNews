package com.bittslife.bittsnews.data.api

import com.bittslife.bittsnews.data.model.NewsData
import com.bittslife.bittsnews.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET("latest")
    suspend fun getData(
        @Query("apikey") apiKey: String = Constants.API_KEY,
        @Query("language") language: String = "hi",
    ): NewsData
}