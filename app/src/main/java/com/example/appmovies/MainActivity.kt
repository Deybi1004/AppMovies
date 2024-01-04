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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appmovies.core.domain.repository.MovieRepository
import com.example.appmovies.home.presentation.HomeScreen
import com.example.appmovies.ui.theme.Background
import com.example.appmovies.ui.theme.MovieDbTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        setContent {
            MovieDbTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ){
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "HOME" ){
                        composable("HOME"){
                            HomeScreen()
                        }
                    }


                }
            }
        }
    }
}
