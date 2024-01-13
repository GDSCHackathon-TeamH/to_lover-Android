package com.tolovers.to_lover

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tolovers.to_lover.databinding.ActivityChoiceloverBinding

class ChoiceLoverActivitiy : AppCompatActivity() {

    private lateinit var binding: ActivityChoiceloverBinding

    private var loverType : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChoiceloverBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tvChoiceloverC1.setOnClickListener{
            binding.tvChoiceloverC1.setTextColor(this.getColor(R.color.white))
            binding.tvChoiceloverC1.setBackgroundColor(this.getColor(R.color.main))
            loverType = binding.tvChoiceloverC1.text.toString()
        }
        binding.tvChoiceloverC2.setOnClickListener{
            binding.tvChoiceloverC2.setTextColor(this.getColor(R.color.white))
            binding.tvChoiceloverC2.setBackgroundColor(this.getColor(R.color.main))
            loverType = binding.tvChoiceloverC2.text.toString()
        }
        binding.btnChoiceloverNext.setOnClickListener {
            next(loverType!!)
        }
    }

    private fun next(loverType : String) {
        val intent = Intent(this, ChoiceDetailActivity::class.java)
        intent.putExtra("lovertype", loverType)
        startActivity(intent)
    }
}