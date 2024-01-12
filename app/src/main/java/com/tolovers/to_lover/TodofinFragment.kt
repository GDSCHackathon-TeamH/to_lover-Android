package com.tolovers.to_lover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tolovers.to_lover.databinding.FragmentRecordTodoFinBinding

class TodofinFragment : Fragment(){
    private lateinit var binding: FragmentRecordTodoFinBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecordTodoFinBinding.inflate(inflater, container, false)

        val fragmentRecordTodoFin  = arguments?.getString("buttonText")
        binding.todoFinActionTv.text = fragmentRecordTodoFin

        binding.todoFinBackBtn.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, TodoingFragment())
                .commitAllowingStateLoss()
        }

        binding.todoFinGodiaryBtn.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, DiarywriteFragment())
                .commitAllowingStateLoss()
        }

        return binding.root
    }

}