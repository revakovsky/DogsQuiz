package com.revakovskyi.cosmogame1.gameScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.revakovskyi.cosmogame1.R
import com.revakovskyi.cosmogame1.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private lateinit var binding: FragmentGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            finishGameButton.setOnClickListener {
                findNavController().navigate(R.id.action_gameFragment_to_resultsFragment)
            }

            backToMenuButton.setOnClickListener {
                findNavController().navigate(R.id.action_gameFragment_to_menuFragment)
            }
        }
    }

}