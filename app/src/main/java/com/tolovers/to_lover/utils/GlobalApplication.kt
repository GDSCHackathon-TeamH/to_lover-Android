package com.tolovers.to_lover.utils

import android.app.Application
import android.content.Context
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication : Application() {
    companion object {
        lateinit var spf : MySharedPreference
    }

    override fun onCreate() {
        spf = MySharedPreference(applicationContext)
        super.onCreate()


        // Kakao SDK 초기화
        KakaoSdk.init(this, "716cb94f22d7725d48ecf5dad244f330")
    }
}

class MySharedPreference (context: Context) {

    private val spf = context.getSharedPreferences("user", Context.MODE_PRIVATE)

    var accessToken: String?
        get() = spf.getString("accesstoekn", "")
        set(value) = spf.edit().putString("accesstoekn", value).apply()
    var Jwt: String?
        get() = spf.getString("jwt", "")
        set(value) = spf.edit().putString("jwt", value).apply()
}