package com.iszero.photato.server.api.auth

import com.iszero.photato.server.RetrofitClient
import com.iszero.photato.server.data.auth.AuthRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun signup(username: String, password: String):Boolean? {
    return withContext(Dispatchers.IO) {
        try {
            val authService = RetrofitClient.authPostService
            val joinRequest = AuthRequest(username, password)
            val response = authService.postSignup(joinRequest)
            true
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}