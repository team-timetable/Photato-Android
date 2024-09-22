package com.iszero.photato.server.api.auth

import android.content.Context
import com.iszero.photato.server.RetrofitClient
import com.iszero.photato.server.another.token.getRefToken
import com.iszero.photato.server.another.token.saveAccToken
import com.iszero.photato.server.another.token.saveRefToken
import com.iszero.photato.server.data.auth.RefreshRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun refresh(context: Context):Boolean? {
    return withContext(Dispatchers.IO) {
        try {
            val refreshToken = getRefToken(context)
            val authService = RetrofitClient.authPostService
            val refreshRequest = RefreshRequest(refreshToken)
            val response = authService.postRefresh(refreshRequest)
            saveAccToken(context, response.accessToken)
            saveRefToken(context, response.refreshToken)
            true
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}