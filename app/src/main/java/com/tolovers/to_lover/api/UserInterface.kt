package com.tolovers.to_lover.api


import com.tolovers.to_lover.dto.LoginReq
import com.tolovers.to_lover.dto.SignupReq
import com.tolovers.to_lover.dto.UserRes
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserInterface {
    @POST("/api/user/login")
    fun login(@Body loginReq: LoginReq) : Call<UserRes>

    @POST("/api/user/signup")
    fun signup(@Body signupReq: SignupReq) : Call<UserRes>
}