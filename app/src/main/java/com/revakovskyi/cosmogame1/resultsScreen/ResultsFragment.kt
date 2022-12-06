package com.revakovskyi.cosmogame1.resultsScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.revakovskyi.cosmogame1.R
import com.revakovskyi.cosmogame1.databinding.FragmentResultsBinding

class ResultsFragment : Fragment() {

    private lateinit var binding: FragmentResultsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            backToMenuButton.setOnClickListener {
                findNavController().navigate(R.id.action_resultsFragment_to_menuFragment)
            }

            returnButton.setOnClickListener {
                findNavController().navigate(R.id.action_resultsFragment_to_gameFragment)
            }

            exitButton.setOnClickListener {
                requireActivity().finish()
            }
        }
    }

}