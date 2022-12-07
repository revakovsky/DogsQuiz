package com.revakovskyi.dogsquiz.menuScreen

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.revakovskyi.dogsquiz.R
import com.revakovskyi.dogsquiz.databinding.FragmentMenuBinding

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