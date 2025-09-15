package com.bittslife.bittsnews.data.repository

import com.bittslife.bittsnews.data.api.NetworkService
import com.bittslife.bittsnews.data.model.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor(private val networkService: NetworkService) {

    fun getNews(): Flow<List<Article>> {
        return flow {
            emit(networkService.getData())
        }.map { it.results }
    }

}