package com.revakovskyi.dogsquiz.resultsScreen

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.revakovskyi.dogsquiz.R
import com.revakovskyi.dogsquiz.databinding.FragmentResultsBinding

class ResultsFragment : Fragment(R.layout.fragment_results) {

    private lateinit var binding: FragmentResultsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentResultsBinding.bind(view)

        binding.apply {
            backToMenuButton.setOnClickListener {
                findNavController().popBackStack(R.id.menuFragment, false)
            }

            returnButton.setOnClickListener {
                findNavController().popBackStack()
            }

            exitButton.setOnClickListener {
                AlertDialog.Builder(requireContext())
                    .setTitle(R.string.exit_big)
                    .setIcon(R.drawable.cancel)
                    .setMessage(R.string.want_to_leave)
                    .setPositiveButton(R.string.yes) { _, _ ->
                        requireActivity().finish()
                    }
                    .setNegativeButton(R.string.no, null)
                    .create()
                    .show()
            }
        }
    }

}