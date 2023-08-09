package com.example.busschedule.network

import com.squareup.moshi.Json

data class Customer(
    val id: Int,
    val name: String,
    val address: String? = "",
    val phone: String? = "",
    @Json(name = "created_at") val createdAt: String,
    @Json(name = "is_active")  val isActive: Boolean,
    @Json(name = "type_id")    val typeId: Int,
    @Json(name = "unit_id")    val unitId: Int,
    @Json(name = "unit_name")  val unitName: String,
    @Json(name = "paket_id")   val paketId: Int,
    @Json(name = "paket_name") val paketName: String
)
