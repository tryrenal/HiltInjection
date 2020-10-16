package com.example.hiltinjection.data.di

import com.example.hiltinjection.data.repositories.LaunchRepositoryImpl
import com.example.hiltinjection.domain.repositories.LaunchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class DataModule {

    @Singleton
    @Binds
    abstract fun bindLaunchRepository(
        launchRepositoryImpl: LaunchRepositoryImpl
    ) : LaunchRepository

}
