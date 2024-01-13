package com.tolovers.to_lover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tolovers.to_lover.databinding.FragmentRecordResultBinding

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentRecordResultBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecordResultBinding.inflate(inflater, container, false)

        val enteredText = arguments?.getString("diaryText")
        binding.recordResultDiaryTv.text = enteredText

        val fragmentRecordResult  = arguments?.getString("buttonText")
        binding.recordResultTodoTv.text = fragmentRecordResult

        binding.recordResultBackBtn.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, DiarywriteFragment())
                .commitAllowingStateLoss()
        }

        binding.recordResultBackBtn.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, DiarywriteFragment())
                .commitAllowingStateLoss()
        }

        //record_result_todo_ll의 색깔 바꾸기

        return binding.root
    }

}