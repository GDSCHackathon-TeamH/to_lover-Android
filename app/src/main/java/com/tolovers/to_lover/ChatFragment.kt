package com.tolovers.to_lover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tolovers.to_lover.databinding.ActivityChatBinding

class ChatFragment : Fragment() {

    private lateinit var binding: ActivityChatBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityChatBinding.inflate(inflater, container, false)

        return binding.root
    }

}