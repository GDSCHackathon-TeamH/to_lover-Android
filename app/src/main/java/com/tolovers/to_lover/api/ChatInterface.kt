package com.tolovers.to_lover.api

import com.tolovers.to_lover.dto.ChatReq
import com.tolovers.to_lover.dto.ChatRes
import com.tolovers.to_lover.dto.SendChatReq
import com.tolovers.to_lover.dto.SendChatRes
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ChatInterface {
    @POST("/api/chat/room")
    fun createChat(
        @Header("jwtAccessToken") jwtAccessToken: String?,
        @Body chatReq: ChatReq) : Call<ChatRes>

    @POST("/api/chat")
    fun sendChat(
        @Header("jwtAccessToken") jwtAccessToken: String?,
        @Body sendChatReq: SendChatReq) : Call<SendChatRes>
}