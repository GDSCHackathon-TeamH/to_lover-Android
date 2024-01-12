package com.tolovers.to_lover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tolovers.to_lover.databinding.ActivityHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityHomeBinding.inflate(inflater, container, false)

        val activityHome  = arguments?.getString("TodoText")
        binding.homeTodoBtn.text = activityHome

        binding.homeTodoBtn.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, TodoingFragment())
                .commitAllowingStateLoss()
        }

        return binding.root
    }

}