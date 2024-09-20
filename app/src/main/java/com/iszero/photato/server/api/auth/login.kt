package com.iszero.photato.server.api.auth

import com.iszero.photato.server.RetrofitClient
import com.iszero.photato.server.data.auth.AuthRequest
import com.iszero.photato.server.data.auth.AuthResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun login(username: String, password: String): AuthResponse? {
    return withContext(Dispatchers.IO) {
        try {
            val authService = RetrofitClient.authPostService
            val loginRequest = AuthRequest(username, password)
            val response = authService.postLogin(loginRequest)
            response
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}