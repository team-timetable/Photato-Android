package com.iszero.photato.server.data.auth

data class AuthResponse(
    val accessToken: String,
    val refreshToken: String,
)
