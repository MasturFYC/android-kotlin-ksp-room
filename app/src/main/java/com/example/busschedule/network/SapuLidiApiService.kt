package com.example.busschedule.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://sapulidi.site/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface SapuLidiApiService {
    @GET("customer/list/{txt}")
    suspend fun getCustomers(txt: String) : List<Customer>

//    companion object {
//    }
}
object SapuLidiApi {
    val retrofitService: SapuLidiApiService by lazy {
        retrofit.create(SapuLidiApiService::class.java)
    }
}