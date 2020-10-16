package com.example.hiltinjection.domain.models

data class Launch(
    val details: String,
    val flight_number: Int,
    val launch_success: Boolean,
    val launch_year: String,
    val links: Links,
    val mission_name: String,
    val rocket: RocketId
)
