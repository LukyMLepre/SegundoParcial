package com.example.segundoparcial.network

import com.example.segundoparcial.Cat
import retrofit2.Call

import retrofit2.http.GET

interface CatApiService {

    @GET("v1/images/search?limit=10")
    fun getCats(): Call<List<Cat>>

}
