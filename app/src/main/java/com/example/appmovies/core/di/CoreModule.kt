package com.example.appmovies.core.di

import com.example.appmovies.core.data.MovieRepositoryImpl
import com.example.appmovies.core.data.remote.MovieApi
import com.example.appmovies.core.data.remote.interceptor.ApiKeyInterceptor
import com.example.appmovies.core.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Provides
    @Singleton
    fun provideApi(): MovieApi {
        val client = OkHttpClient.Builder().addInterceptor(ApiKeyInterceptor()).build()
        return Retrofit.Builder().baseUrl(MovieApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create()).client(client).build().create()
    }

    @Singleton
    @Provides
    fun provideRepository(api: MovieApi): MovieRepository {
        return MovieRepositoryImpl(api)
    }
}