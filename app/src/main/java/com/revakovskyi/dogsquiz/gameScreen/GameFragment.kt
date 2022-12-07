package com.revakovskyi.dogsquiz.gameScreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.revakovskyi.dogsquiz.R
import com.revakovskyi.dogsquiz.databinding.FragmentGameBinding

class GameFragment : Fragment(R.layout.fragment_game) {

    private lateinit var binding: FragmentGameBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGameBinding.bind(view)

        binding.apply {
            finishGameButton.setOnClickListener {
                findNavController().navigate(R.id.action_gameFragment_to_resultsFragment)
            }

            backToMenuButton.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

}