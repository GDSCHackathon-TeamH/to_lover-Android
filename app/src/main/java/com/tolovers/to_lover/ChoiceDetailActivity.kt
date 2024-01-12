package com.tolovers.to_lover

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tolovers.to_lover.databinding.ActivityChociedetailBinding

class ChoiceDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChociedetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChociedetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}