package com.tolovers.to_lover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tolovers.to_lover.databinding.FragmentRecordDiarylistBinding

class DiarylistFragment : Fragment() {
    lateinit var binding: FragmentRecordDiarylistBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRecordDiarylistBinding.inflate(inflater, container, false)

        return binding.root
    }
}