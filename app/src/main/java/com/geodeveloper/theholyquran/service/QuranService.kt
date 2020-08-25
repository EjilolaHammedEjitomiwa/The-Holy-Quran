package com.geodeveloper.theholyquran.service

import com.geodeveloper.theholyquran.models.QuranEditionModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface QuranService {
    //non filter
    @GET("edition")
    fun getQuranEditions(): Call<QuranEditionModel>
    @GET("edition")
    fun getQuranEditionsFilter(@QueryMap filter:HashMap<String,String?>): Call<QuranEditionModel>
}