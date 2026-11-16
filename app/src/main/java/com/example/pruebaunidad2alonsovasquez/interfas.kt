package com.example.pruebaunidad2alonsovasquez

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Body

data class LoginRequest(val username: String, val passwordHash: String)
data class SensorData(
    val temp: Float,
    val hum: Int,
    val suelo: Int,
    val bomba: Boolean,
    val ventilador: Boolean
)

interface ApiService {
    @POST("api/login")
    suspend fun login(@Body request: LoginRequest): Response<Unit>

    @POST("api/registro")
    suspend fun registrar(@Body request: LoginRequest): Response<Unit>

    @GET("api/datos")
    suspend fun getDatos(): Response<SensorData>

    @GET("api/bomba/on")
    suspend fun encenderBomba(): Response<Unit>

    @GET("api/bomba/off")
    suspend fun apagarBomba(): Response<Unit>

    @GET("api/ventilador/on")
    suspend fun encenderVentilador(): Response<Unit>

    @GET("api/ventilador/off")
    suspend fun apagarVentilador(): Response<Unit>

    @GET("api/ambos/on")
    suspend fun encenderAmbos(): Response<Unit>

    @GET("api/ambos/off")
    suspend fun apagarAmbos(): Response<Unit>
}