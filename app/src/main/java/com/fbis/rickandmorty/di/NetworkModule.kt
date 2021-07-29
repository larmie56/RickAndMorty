package com.fbis.rickandmorty.di

import com.fbis.rickandmorty.BuildConfig
import com.fbis.rickandmorty.api.CharacterApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    private fun getClient(): OkHttpClient {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder().addInterceptor(logger).build()
    }

    private fun getConverterFactory(): Moshi {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(getConverterFactory()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(getClient())
            .build()
    }

    @Provides
    @Singleton
    fun providesApiService(): CharacterApiService {
        return getRetrofit().create(CharacterApiService::class.java)
    }
}