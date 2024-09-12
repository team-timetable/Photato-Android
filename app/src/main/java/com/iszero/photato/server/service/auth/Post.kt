package com.iszero.photato.server.service.auth

import com.iszero.photato.server.data.AuthRequest
import com.iszero.photato.server.data.AuthResponse
import com.iszero.photato.server.data.RefreshRequest
import com.iszero.photato.server.data.RefreshResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface Post {
    @POST("auth/signup")
    suspend fun postSignup(@Body request: AuthRequest)
    @POST("auth/login")
    suspend fun postLogin(@Body request: AuthRequest): AuthResponse
    @POST("auth/refresh")
    suspend fun postRefresh(@Body request: RefreshRequest): RefreshResponse
}