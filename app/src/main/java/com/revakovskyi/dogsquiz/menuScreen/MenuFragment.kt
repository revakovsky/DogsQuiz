package com.revakovskyi.dogsquiz.menuScreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.revakovskyi.dogsquiz.R
import com.revakovskyi.dogsquiz.databinding.FragmentMenuBinding
import com.revakovskyi.dogsquiz.utils.setExitAlertDialog

class MenuFragment : Fragment(R.layout.fragment_menu) {

    private lateinit var binding: FragmentMenuBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMenuBinding.bind(view)

        binding.apply {
            startGameButton.setOnClickListener {
                findNavController().navigate(R.id.action_menuFragment_to_gameFragment)
            }

            exitButton.setOnClickListener {
                setExitAlertDialog()
            }
        }
    }

}