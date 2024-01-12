package com.tolovers.to_lover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tolovers.to_lover.databinding.FragmentRecordTodoBinding

class TodoFragment : Fragment() {
    private lateinit var binding: FragmentRecordTodoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecordTodoBinding.inflate(inflater, container, false)

        binding.todoBackBtn.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, RecordFragment())
                .commitAllowingStateLoss()
        }

        binding.todoAction1Btn.setOnClickListener {
            handleButtonClick(binding.todoAction1Btn.text.toString())

            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, TodoingFragment())
                .commitAllowingStateLoss()
        }

        binding.todoAction2Btn.setOnClickListener {
            handleButtonClick(binding.todoAction2Btn.text.toString())

            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, TodoingFragment())
                .commitAllowingStateLoss()
        }

        binding.todoAction3Btn.setOnClickListener {
            handleButtonClick(binding.todoAction3Btn.text.toString())

            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, TodoingFragment())
                .commitAllowingStateLoss()
        }

        return binding.root
    }

    private fun handleButtonClick(buttonText: String) {
        val bundle = Bundle()
        bundle.putString("buttonText", buttonText)

        val activityHome = HomeFragment()
        val fragmentRecordTodoIng = TodoingFragment()
        val fragmentRecordTodoFin = TodofinFragment()
        val fragmentRecordResult = ResultFragment()
        activityHome.arguments = bundle
        fragmentRecordTodoIng.arguments = bundle
        fragmentRecordTodoFin.arguments = bundle
        fragmentRecordResult.arguments = bundle

        val fragmentManager = requireActivity().supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.main_frm, activityHome)
        transaction.replace(R.id.main_frm, fragmentRecordTodoIng)
        transaction.replace(R.id.main_frm, fragmentRecordTodoFin)
        transaction.replace(R.id.main_frm, fragmentRecordResult)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}