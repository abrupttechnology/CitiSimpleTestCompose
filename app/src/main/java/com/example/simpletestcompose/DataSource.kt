package com.example.simpletestcompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import fetchData

class DataSource {

    private var initialArticleList = fetchData()
    var articleList by mutableStateOf(initialArticleList)

    fun onNewArticleList(onArticleListText: MutableList<Article>) {
        articleList = onArticleListText
    }
    companion object {
        private var INSTANCE: DataSource? = null

        fun getDataSource(): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource()
                INSTANCE = newInstance
                newInstance
            }
        }
    }
}
