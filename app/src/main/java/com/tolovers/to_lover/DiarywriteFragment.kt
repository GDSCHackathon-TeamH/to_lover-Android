package com.tolovers.to_lover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tolovers.to_lover.databinding.FragmentRecordDiaryWriteBinding

class DiarywriteFragment : Fragment() {

    private lateinit var  binding: FragmentRecordDiaryWriteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecordDiaryWriteBinding.inflate(inflater, container, false)

        binding.diaryWriteBackBtn.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, TodofinFragment())
                .commitAllowingStateLoss()
        }

        binding.diaryWriteFinBtn.setOnClickListener {
            val enteredText = binding.diaryWriteEt.text.toString()

            val resultFragment = ResultFragment()
            val bundle = Bundle()
            bundle.putString("diaryText", enteredText)
            resultFragment.arguments = bundle

            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, resultFragment)
                .commitAllowingStateLoss()
        }

        return binding.root
    }

}