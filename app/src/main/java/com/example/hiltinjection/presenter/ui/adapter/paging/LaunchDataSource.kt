package com.example.hiltinjection.presenter.ui.adapter.paging

import androidx.paging.PageKeyedDataSource
import com.example.hiltinjection.domain.models.Launch
import com.example.hiltinjection.domain.usecases.launch.LaunchUseCase
import com.example.hiltinjection.domain.utils.PAGE_SIZE
import com.example.hiltinjection.domain.utils.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LaunchDataSource(private val launchUseCase: LaunchUseCase) : PageKeyedDataSource<Int, Launch>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Launch>
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            when (val result = launchUseCase.execute(LaunchUseCase.Params(0))) {
                is Result.Success -> callback.onResult(result.data, 0, PAGE_SIZE)
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Launch>) {
        CoroutineScope(Dispatchers.IO).launch {
            when (val result = launchUseCase.execute(LaunchUseCase.Params(params.key))) {
                is Result.Success -> {
                    if(result.data.isNotEmpty())
                    callback.onResult(result.data, params.key + PAGE_SIZE)
                }
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Launch>) {
    }
}