package com.iszero.photato.server.data

data class RefreshResponse (
    val accessToken: String,
    val refreshToken: String
)