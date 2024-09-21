package com.iszero.photato.server.another.token

import android.content.Context
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

fun getRefToken(context: Context): String {
    return runBlocking {
        val preferences = context.dataStore.data.first()
        "Bearer "+preferences[REF_TOKEN]
    }
}
fun getAccToken(context: Context): String? {
    return runBlocking {
        val preferences = context.dataStore.data.first()
        preferences[ACC_TOKEN]
    }
}