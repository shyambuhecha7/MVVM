package com.shyam.interview_shyam.retrofit

import com.shyam.interview_shyam.Model.Therapies
import retrofit2.http.GET

interface APIInterface {
    @GET("therapies")
    suspend fun getData(): Therapies
}