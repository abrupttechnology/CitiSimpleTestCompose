package com.example.simpletestcompose

import ArticleCard
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.simpletestcompose.ui.theme.SimpleTestComposeTheme

class MainActivity : ComponentActivity() {

    private val mainViewModel by viewModels<MainViewModel> {
        MainViewModelListFactory(this)
    }
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            SimpleTestComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Articles()
                }
            }
        }
    }

    @Composable
    fun Articles() {
        var articles: MutableList<Article> = mainViewModel.articlesList
        LazyColumn {
            items(articles) { article ->
                ArticleCard(article)
            }
        }
    }
}
