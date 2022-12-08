package com.revakovskyi.dogsquiz.utils

import android.app.AlertDialog
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.revakovskyi.dogsquiz.R

fun Fragment.setExitAlertDialog() {
    AlertDialog.Builder(requireContext())
        .setTitle(R.string.exit)
        .setIcon(R.drawable.cancel)
        .setMessage(R.string.want_to_leave)
        .setPositiveButton(R.string.yes) { _, _ ->
            requireActivity().finish()
        }
        .setNegativeButton(R.string.no, null)
        .create()
        .show()
}

fun Fragment.makeToast(textResource: Int): Toast {
    return Toast.makeText(requireActivity(), textResource, Toast.LENGTH_LONG)
}