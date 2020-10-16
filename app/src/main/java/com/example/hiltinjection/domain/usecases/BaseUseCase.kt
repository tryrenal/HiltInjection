package com.example.hiltinjection.domain.usecases

import com.example.hiltinjection.domain.utils.Result

abstract class BaseUseCase<T : Any, in Params> {
    abstract suspend fun execute(params: Params?): Result<T>
}