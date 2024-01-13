package com.tolovers.to_lover.api

import com.tolovers.to_lover.dto.Advise
import com.tolovers.to_lover.dto.DiaryCall
import com.tolovers.to_lover.dto.DiaryDateCall
import com.tolovers.to_lover.dto.DiaryReq
import com.tolovers.to_lover.dto.DiarySave
import com.tolovers.to_lover.dto.Todo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface DiaryInterface {

    @GET("/getRandomAdvice")
    fun advise(@Header("X-ACCESS-TOKEN") jwt: String?) : Call<Advise>

    @POST("/api/posts/save")
    fun diaryText(@Body diarySave: DiarySave) : Call<DiaryReq>

    @GET("/api/posts/findByUserAndData?date=날짜")
    fun dateDiary(@Header("jwtAccessToken") jwt: String?) : Call<DiaryCall>

    @GET("/getRandomTodo")
    fun todo(@Header("X-ACCESS-TOKEN") jwt: String?) : Call<Todo>

    @GET("/findByUserAndDateAndTodoId?date=날짜&todoId=할일ID")
    fun dateTodoDiary(@Header("X-ACCESS-TOKEN") jwt: String?) : Call<DiaryDateCall>

}