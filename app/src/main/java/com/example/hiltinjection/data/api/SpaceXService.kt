package com.example.hiltinjection.data.api


import com.example.hiltinjection.domain.models.Launch
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SpaceXService {

    @GET("v3/launches/?filter=flight_number,mission_name,launch_year,rocket/rocket_name," +
            "launch_success,links/mission_patch_small,details")
    suspend fun getLaunches(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Response<ArrayList<Launch>>
}
