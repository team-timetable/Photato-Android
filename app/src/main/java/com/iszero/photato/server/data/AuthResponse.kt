package com.iszero.photato.server.data

data class AuthResponse(
    val accessToken: String,
    val refreshToken: String,
)
