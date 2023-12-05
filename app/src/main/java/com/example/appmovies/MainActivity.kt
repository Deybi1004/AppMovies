package com.example.appmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.appmovies.core.domain.repository.MovieRepository
import com.example.appmovies.ui.theme.MovieDbTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity() : AppCompatActivity() {

    @Inject
    lateinit var repository : MovieRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MovieDbTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ){
                    Greeting()

                    LaunchedEffect(true) {
                        val movies = repository.getUpcomingMovies()
                        println(movies)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(){
    Text(text = "Hello Android")
}

 @Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    MovieDbTheme {
        Greeting()
    }
}