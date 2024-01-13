package com.tolovers.to_lover.dto

import com.google.gson.annotations.SerializedName
import java.util.Date

data class Advise(
    @SerializedName("id") val id : Int?,
    @SerializedName("text") val text : String?,
)

data class DiarySave(
    @SerializedName("diaryText") val diaryText : String?,
    @SerializedName("createdAt") val createdAt : Date?,
    @SerializedName("todoID") val todoID : Int?,
)

data class DiaryReq(
    @SerializedName("body") val body : String?,
    @SerializedName("todoId") val todoId : Int?,
)

data class DiaryCall(
    @SerializedName("body") val body : String?,
    @SerializedName("createdAt") val createdAt : Date?,
    @SerializedName("todoId") val todoId : Int?,
    @SerializedName("userId") val userId : Int?,
)

data class Todo(
    @SerializedName("id") val id : Int?,
    @SerializedName("text") val text : String?,
)

data class DiaryDateCall(
    @SerializedName("diaryText") val diaryText : String?,
    @SerializedName("createdAt") val createdAt : Date?,
    @SerializedName("todo") val todo : String?,
)