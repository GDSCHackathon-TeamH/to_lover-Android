package com.tolovers.to_lover.utils

import com.tolovers.to_lover.api.ChatInterface
import com.tolovers.to_lover.api.UserInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val BASE_URL = "http://sidemoney.site"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val userApi = retrofit.create<UserInterface>(UserInterface::class.java)
    val chatApi = retrofit.create<ChatInterface>(ChatInterface::class.java)

}