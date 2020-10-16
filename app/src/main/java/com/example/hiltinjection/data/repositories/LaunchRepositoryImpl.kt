package com.example.hiltinjection.data.repositories

import com.example.hiltinjection.data.di.RetrofitModule
import com.example.hiltinjection.domain.models.Launch
import com.example.hiltinjection.domain.repositories.LaunchRepository
import com.example.hiltinjection.domain.utils.PAGE_SIZE
import com.example.hiltinjection.domain.utils.Result
import javax.inject.Inject

class LaunchRepositoryImpl @Inject constructor() : LaunchRepository {

    private val spaceXApi = RetrofitModule.provideSpaceXAPI()

    override suspend fun getLaunches(offset: Int): Result<ArrayList<Launch>> {
        val response = spaceXApi.getLaunches(offset, PAGE_SIZE)
        return when (response.code()) {
            200 -> Result.Success(response.body()!!)
            else -> Result.Failure(Exception())
        }
    }
}