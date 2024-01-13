package com.tolovers.to_lover

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kakao.sdk.common.util.SdkLogLevel
import com.tolovers.to_lover.databinding.ActivityChociedetailBinding
import com.tolovers.to_lover.dto.ChatReq
import com.tolovers.to_lover.dto.ChatRes
import com.tolovers.to_lover.utils.GlobalApplication
import com.tolovers.to_lover.utils.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChoiceDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChociedetailBinding

    private  var communicator  : String? = null
    private  var specific_situation  : String? = null
    private  var conversation_subject  : String? = null
    private  var mbti  : String? = null
    private  var characteristic  : String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChociedetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        choiceDetail()

        binding.btnChoicedetailNext.setOnClickListener {
            choiceLover(ChatReq(communicator, specific_situation, conversation_subject, mbti, characteristic))
            Log.d("CreateCHAT", ChatReq(communicator, specific_situation, conversation_subject, mbti, characteristic).toString())
        }

    }

    private fun choiceDetail() {
        binding.etChoicedetailType.setOnClickListener {
            binding.etChoicedetailType.setTextColor(this.getColor(R.color.white))
            binding.etChoicedetailType.setBackgroundColor(this.getColor(R.color.main))
            communicator = binding.etChoicedetailType.text.toString()
        }
        binding.etChoicedetailCharac2.setOnClickListener {
            binding.etChoicedetailCharac2.setTextColor(this.getColor(R.color.white))
            binding.etChoicedetailCharac2.setBackgroundColor(this.getColor(R.color.main))
            characteristic = binding.etChoicedetailCharac2.text.toString()
        }
        binding.etChoicedetailMbti.setOnClickListener {
            mbti = binding.etChoicedetailMbti.text.toString()
        }
        binding.etChoicedetailTalk.setOnClickListener {
            binding.etChoicedetailTalk.setTextColor(this.getColor(R.color.white))
            binding.etChoicedetailTalk.setBackgroundColor(this.getColor(R.color.main))
            conversation_subject = binding.etChoicedetailTalk.text.toString()
        }
        binding.etChoicedetailDetail.setOnClickListener {
            specific_situation = binding.etChoicedetailDetail.text.toString()
        }
    }

    private fun choiceLover(chatReq: ChatReq) {
        RetrofitClient.chatApi.createChat(GlobalApplication.spf.Jwt,chatReq).enqueue(object : Callback<ChatRes> {

            override fun onResponse(call: Call<ChatRes>, response: Response<ChatRes>) {
                if(response.isSuccessful){
                    val chatResult: ChatRes? = response.body()
                    Log.d("chatUP", "onResponse 성공: " + chatResult?.toString())
                    val intentchat = Intent(applicationContext, ChatActivity::class.java)
                    intentchat.putExtra("roomId", chatResult?.result?.chatRoomId)
                    intentchat.putExtra("firstm", chatResult?.result?.firstMessage)
                    startActivity(intentchat)
                }else{
                    Log.d("chatUP", "onResponse 실패")
                }
            }
            override fun onFailure(call: Call<ChatRes>, t: Throwable) {
                Log.d("chatUP/ERROR", t.message.toString())
            }
        })
    }
    private fun goChat() {
        startActivity(Intent(this, ChatActivity::class.java))
    }
}