package com.geodeveloper.theholyquran.service

import android.annotation.SuppressLint
import android.os.Build
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

object ServiceBuilder {
    //url of the server
    private const val URL = "http://api.alquran.cloud/v1/"

    //creating logger
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    //creating header interceptors
//    val headerInterceptor = object : Interceptor {
//        @SuppressLint("ConstantLocale")
//        override fun intercept(chain: Interceptor.Chain): Response {
//            var request = chain.request()
//            request = request.newBuilder().addHeader("x-device-type", Build.DEVICE).addHeader("Accept-Language", Locale.getDefault().language).build()
//            val response = chain.proceed(request)
//            return response
//        }
//    }

    //http client
    private val okHttpClient = OkHttpClient.Builder().addInterceptor(logger)

    //create the builder
    private val builder = Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).client(okHttpClient.build())

    //create instance of retrofit
    private val retrofit = builder.build()

    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }

}