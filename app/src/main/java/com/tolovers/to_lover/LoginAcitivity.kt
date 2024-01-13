package com.tolovers.to_lover

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.common.util.Utility
import com.kakao.sdk.user.UserApiClient
import com.tolovers.to_lover.databinding.ActivityLoginBinding
import com.tolovers.to_lover.dto.LoginReq
import com.tolovers.to_lover.dto.UserRes
import com.tolovers.to_lover.utils.GlobalApplication
import com.tolovers.to_lover.utils.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginAcitivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLoginKakaologin.setOnClickListener {
            kakalogin()
        }
    }

    private fun kakalogin() {
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                Log.e("KAKAOLOGIN", "카카오계정으로 로그인 실패", error)
            } else if (token != null) {
                Log.i("KAKAOLOGIN", "카카오계정으로 로그인 성공 ${token.accessToken}")
                GlobalApplication.spf.accessToken = token.accessToken
                postLogin(LoginReq(token.accessToken))

            }
        }
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
            UserApiClient.instance.loginWithKakaoTalk(this) { token, error ->
                if (error != null) {
                    Log.e("KAKAOLOGIN", "카카오톡으로 로그인 실패", error)

                    if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                        return@loginWithKakaoTalk
                    }

                    // 카카오톡에 연결된 카카오계정이 없는 경우, 카카오계정으로 로그인 시도
                    UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
                } else if (token != null) {
                    Log.i("KAKAOLOGIN", "카카오톡으로 로그인 성공 ${token.accessToken}")
                }
            }
        } else {
            UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
        }
    }

    private fun goMain() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun goSignup() {
        startActivity(Intent(this, SignupActivity::class.java))
    }

    private fun postLogin(loginReq: LoginReq) {
        RetrofitClient.userApi.login(loginReq).enqueue(object :
            Callback<UserRes> {
            override fun onResponse(call: Call<UserRes>, response: Response<UserRes>) {
                if(response.isSuccessful){
                    val result: UserRes? = response.body()
                    Log.d("LOGIN", "onResponse 성공: " + result?.toString())
                    checkSign(result)
                }else{
                    Log.d("LOGIN", "onResponse 실패")
                }
            }
            override fun onFailure(call: Call<UserRes>, t: Throwable) {
                Log.d("LOGIN/ERROR", t.message.toString())
            }
        })
    }

    private fun checkSign(userRes: UserRes?) {
        if (userRes?.result?.resultMessage == "회원가입 필요") {
            goSignup()
        } else {
            GlobalApplication.spf.Jwt = userRes?.result?.accessJwt
            goMain()
        }

    }
}