package com.example.hiltinjection.data.di

import com.example.hiltinjection.data.api.SpaceXService
import com.example.hiltinjection.domain.utils.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideSpaceXAPI() : SpaceXService {
        return providerWebService<SpaceXService>()
    }


    private inline fun <reified T> providerWebService(): T {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(providerOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(T::class.java)
    }

    private fun providerOkHttpClient() = OkHttpClient.Builder().apply {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        addInterceptor(logging)
    }.build()



}