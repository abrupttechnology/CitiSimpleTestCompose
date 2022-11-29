package com.example.simpletestcompose

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModel(val dataSource: DataSource) : ViewModel() {

    var articlesList = dataSource.articleList
    fun onNewArticleList(onArticleListText: MutableList<Article>) {
        articlesList = onArticleListText
    }
}

class MainViewModelListFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(
                dataSource = DataSource.getDataSource()
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
