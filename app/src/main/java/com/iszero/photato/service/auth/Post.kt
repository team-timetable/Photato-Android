package com.iszero.photato.service.auth

import retrofit2.http.Body
import retrofit2.http.POST

interface Post {
    @POST("auth/signup")
    suspend fun postSignup(@Body request: SignupRequest): SignupResponse
    @POST("auth/login")
    suspend fun postLogin(@Body request: LoginRequest): LoginResponse
    @POST("auth/refresh")
    suspend fun postRefresh(@Body request: RefRequest): RefResponse

}