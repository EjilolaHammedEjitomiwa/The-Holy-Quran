package com.geodeveloper.theholyquran.service

import com.geodeveloper.theholyquran.models.englishquran.QuranModel
import com.geodeveloper.theholyquran.models.quraneditions.QuranEditionModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface QuranService {

    //non filter
    @GET("edition")
    fun getQuranEditions(): Call<QuranEditionModel>
    @GET("edition")
    fun getQuranEditionsFilter(@QueryMap filter:HashMap<String,String?>): Call<QuranEditionModel>

    //get english translation
    @GET("quran/en.sahih")
    fun  getEnglishQuran(): Call<QuranModel>
    //get english translation
    @GET("quran/ar.abdullahbasfar")
    fun  getArabicQuran(): Call<QuranModel>

}