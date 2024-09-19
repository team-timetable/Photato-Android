package com.iszero.photato.server

import com.iszero.photato.BuildConfig
import com.iszero.photato.server.service.auth.Post
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var retrofit: Retrofit? = null

    fun getClient(baseUrl: String): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }

    val authPostService: Post by lazy {
        val url = BuildConfig.BASE_URL
        getClient(url).create(Post::class.java)
    }
}