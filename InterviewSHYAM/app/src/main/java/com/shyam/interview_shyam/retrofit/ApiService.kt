package com.shyam.interview_shyam.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://mindmyscape.localserverpro.com/api/doctor/"

object ApiService {
    val instance: APIInterface

    init {
        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()

        instance = retrofit.create(APIInterface::class.java)
    }
}