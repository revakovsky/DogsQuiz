package com.revakovskyi.dogsquiz.resultsScreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.revakovskyi.dogsquiz.R
import com.revakovskyi.dogsquiz.databinding.FragmentResultsBinding
import com.revakovskyi.dogsquiz.utils.setExitAlertDialog

class ResultsFragment : Fragment(R.layout.fragment_results) {

    private lateinit var binding: FragmentResultsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentResultsBinding.bind(view)

        binding.apply {
            returnButton.setOnClickListener {
                findNavController().popBackStack(R.id.menuFragment, false)
            }

            exitResultsButton.setOnClickListener {
                setExitAlertDialog()
            }
        }
    }

}