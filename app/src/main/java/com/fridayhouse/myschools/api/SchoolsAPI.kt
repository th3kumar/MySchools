package com.fridayhouse.myschools.api

import com.fridayhouse.myschools.SchoolsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SchoolsAPI {

    // Suspend function to get all schools
    @GET("search")
    suspend fun getAllSchools(
        @Query("page")
        pageNumber: Int = 1
    ): List<SchoolsResponse>

    // Suspend function to get schools by name
    @GET("search")
    suspend fun getSchoolsByName(
        @Query("name")
        name: String,
        @Query("page")
        pageNumber: Int = 1
    ): List<SchoolsResponse>

    // Suspend function to get schools by country
    @GET("search")
    suspend fun getSchoolsByCountry(
        @Query("country")
        country: String,
        @Query("page")
        pageNumber: Int = 1
    ): List<SchoolsResponse>
}