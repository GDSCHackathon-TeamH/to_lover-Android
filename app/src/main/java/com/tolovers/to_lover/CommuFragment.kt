package com.tolovers.to_lover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tolovers.to_lover.databinding.ActivityCommuBinding

class CommuFragment : Fragment() {
    private lateinit var binding: ActivityCommuBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityCommuBinding.inflate(inflater, container, false)

        return binding.root
    }

}