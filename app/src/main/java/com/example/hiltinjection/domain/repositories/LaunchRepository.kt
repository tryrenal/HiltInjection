package com.example.hiltinjection.domain.repositories

import com.example.hiltinjection.domain.models.Launch
import com.example.hiltinjection.domain.utils.Result

interface LaunchRepository {
    suspend fun getLaunches(offset : Int) : Result<ArrayList<Launch>>
}