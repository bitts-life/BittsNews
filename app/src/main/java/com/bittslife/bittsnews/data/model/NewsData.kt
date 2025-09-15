package com.bittslife.bittsnews.data.model

data class NewsData(
    val nextPage: String,
    val results: List<Article>,
    val status: String,
    val totalResults: Int
)