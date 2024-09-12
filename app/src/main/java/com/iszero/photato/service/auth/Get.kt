package com.iszero.photato.service.auth

import retrofit2.http.GET
import retrofit2.http.Header

interface Get {
    @GET("auth/me")
    suspend fun getMe(
        @Header("Authorization") token: String,
    ): MeResponse
}