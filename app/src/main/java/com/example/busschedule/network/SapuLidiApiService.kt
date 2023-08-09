package com.example.busschedule.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.ResponseBody
import retrofit2.Response

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


// referrences:
// https://johncodeos.com/how-to-make-post-get-put-and-delete-requests-with-retrofit-using-kotlin/
// https://www.c-sharpcorner.com/article/call-post-api-in-android-using-retrofit/

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
    suspend fun getCustomers(@Path("txt") customerName: String) : List<Customer>

//    companion object {
//    }
}
object SapuLidiApi {
    val retrofitService: SapuLidiApiService by lazy {
        retrofit.create(SapuLidiApiService::class.java)
    }
}