package com.example.appmovies.home.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appmovies.core.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val repository: MovieRepository
) : ViewModel() {
    var state by mutableStateOf(HomeState())
        private set

    init {
        state = state.copy(isLoading = true)

        // If the coroutines finished , is Loading will be false
       viewModelScope.launch {
           supervisorScope {
               val upcoming = launch { getUpcomingMovies() }
               val popular = launch { getPopularMovies() }
               listOf(upcoming,popular).forEach { it.join() }
               state = state.copy(isLoading = false)
           }
       }

    }

    private suspend fun getUpcomingMovies() {
        repository.getUpcomingMovies().onSuccess {
            state = state.copy(
                upcomingMovies = it
            )
        }.onFailure {
            println()
        }
    }

    private suspend fun getPopularMovies() {
        repository.getPopularMovies().onSuccess {
            state = state.copy(
                popularMovies = it
            )
        }.onFailure {
            println()
        }
    }
}