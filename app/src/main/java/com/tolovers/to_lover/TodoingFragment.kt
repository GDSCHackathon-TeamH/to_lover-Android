package com.tolovers.to_lover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tolovers.to_lover.databinding.FragmentRecordTodoIngBinding

class TodoingFragment : Fragment() {

    private lateinit var binding: FragmentRecordTodoIngBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecordTodoIngBinding.inflate(inflater, container, false)

        val fragmentRecordTodoIng = arguments?.getString("buttonText")
        binding.todoIngActionTv.text = fragmentRecordTodoIng

        binding.todoIngBackBtn.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, TodoFragment())
                .commitAllowingStateLoss()
        }

        binding.todoIngGodiaryBtn.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, TodofinFragment())
                .commitAllowingStateLoss()
        }

        return binding.root
    }
}