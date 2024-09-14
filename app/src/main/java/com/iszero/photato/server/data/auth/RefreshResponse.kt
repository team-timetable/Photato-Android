package com.iszero.photato.server.data.auth

data class RefreshResponse (
    val accessToken: String,
    val refreshToken: String
)