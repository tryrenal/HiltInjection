package com.example.hiltinjection.presenter.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.hiltinjection.domain.models.Launch
import com.example.hiltinjection.domain.usecases.launch.LaunchUseCase
import com.example.hiltinjection.domain.utils.PAGE_SIZE
import com.example.hiltinjection.presenter.ui.adapter.paging.LaunchDataSource


class LaunchesViewModel @ViewModelInject constructor(private val launchUseCase: LaunchUseCase): ViewModel() {

    val pagedListLaunch: LiveData<PagedList<Launch>>

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(PAGE_SIZE)
            .setEnablePlaceholders(false)
            .build()
        pagedListLaunch = initializedPagedListBuilder(config).build()
    }

    private fun initializedPagedListBuilder(config: PagedList.Config)
            : LivePagedListBuilder<Int, Launch> {

        val dataSourceFactory = object : DataSource.Factory<Int, Launch>() {
            override fun create(): DataSource<Int, Launch> {
                return LaunchDataSource(launchUseCase)
            }
        }
        return LivePagedListBuilder<Int, Launch>(dataSourceFactory, config)
    }
}