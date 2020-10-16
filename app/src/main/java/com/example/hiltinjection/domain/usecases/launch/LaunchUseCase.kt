package com.example.hiltinjection.domain.usecases.launch

import com.example.hiltinjection.domain.models.Launch
import com.example.hiltinjection.domain.repositories.LaunchRepository
import com.example.hiltinjection.domain.usecases.BaseUseCase
import java.lang.Exception
import com.example.hiltinjection.domain.utils.Result
import javax.inject.Inject

class LaunchUseCase @Inject constructor(private val launchRepository: LaunchRepository) :
    BaseUseCase<ArrayList<Launch>, LaunchUseCase.Params>() {

    data class Params(val offset: Int)

    override suspend fun execute(params: Params?): Result<ArrayList<Launch>> {
        if (params == null) throw IllegalArgumentException()
        return when (val result = launchRepository.getLaunches(params.offset)) {
            is Result.Success -> Result.Success(result.data)
            is Result.Failure -> Result.Failure(Exception())
        }
    }
}