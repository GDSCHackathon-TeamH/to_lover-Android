package com.tolovers.to_lover

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.tolovers.to_lover.databinding.ActivitySignupBinding
import com.tolovers.to_lover.dto.SignupReq
import com.tolovers.to_lover.dto.UserRes
import com.tolovers.to_lover.utils.GlobalApplication
import com.tolovers.to_lover.utils.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnJoinSignup.setOnClickListener {
            val nickname: String = binding.etJoinNickname.text.toString()
            signUp(SignupReq(GlobalApplication.spf.accessToken,nickname))
        }
    }

    private fun goMain() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun signUp(signupReq: SignupReq) {
        RetrofitClient.userApi.signup(signupReq).enqueue(object : Callback<UserRes> {
            override fun onResponse(call: Call<UserRes>, response: Response<UserRes>) {
                if(response.isSuccessful){
                    val signResult: UserRes? = response.body()
                    Log.d("SIGNUP", "onResponse 성공: " + signResult?.toString())
                    GlobalApplication.spf.Jwt = signResult?.result?.accessJwt
                    goMain()
                }else{
                    Log.d("SIGNUP", "onResponse 실패")
                }
            }
            override fun onFailure(call: Call<UserRes>, t: Throwable) {
                Log.d("SIGNUP/ERROR", t.message.toString())
            }
        })
    }
}