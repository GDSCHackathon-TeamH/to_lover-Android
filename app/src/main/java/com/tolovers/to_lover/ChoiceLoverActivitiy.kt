package com.tolovers.to_lover

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tolovers.to_lover.databinding.ActivityChoiceloverBinding

class ChoiceLoverActivitiy : AppCompatActivity() {

    private lateinit var binding: ActivityChoiceloverBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChoiceloverBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvChoiceloverC1.setOnClickListener{
            val loverType = binding.tvChoiceloverC1.text

        }
        binding.tvChoiceloverC2.setOnClickListener{
            val loverType = binding.tvChoiceloverC2.text

        }
    }
}