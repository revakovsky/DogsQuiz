package com.revakovskyi.dogsquiz.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.revakovskyi.dogsquiz.R
import com.revakovskyi.dogsquiz.databinding.FragmentResultsBinding
import com.revakovskyi.dogsquiz.model.QuestionsList
import com.revakovskyi.dogsquiz.model.QuestionsList.Companion.GOOD_KNOWLEDGE_LEVEL
import com.revakovskyi.dogsquiz.model.QuestionsList.Companion.PERFECT_KNOWLEDGE_LEVEL
import com.revakovskyi.dogsquiz.utils.setExitAlertDialog

class ResultsFragment : Fragment(R.layout.fragment_results) {

    private lateinit var binding: FragmentResultsBinding

    private lateinit var cubIcon: ImageView
    private lateinit var score: TextView
    private lateinit var description: TextView

    private val totalQuestion: String = QuestionsList.MAX_AMOUNT_OF_QUESTIONS.toString()
    private var totalCorrectAnswers: String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentResultsBinding.bind(view)

        initViews()
        setValues()
        setUpButtonsAction()
    }

    private fun setUpButtonsAction() {
        binding.apply {
            returnButton.setOnClickListener {
                findNavController().popBackStack(R.id.menuFragment, false)
            }

            exitResultsButton.setOnClickListener {
                setExitAlertDialog()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setValues() {
        if (totalCorrectAnswers.toInt() > PERFECT_KNOWLEDGE_LEVEL) {
            cubIcon.setImageResource(R.drawable.win_gold)
            description.text = getString(R.string.user_description_perfect)
        } else if (totalCorrectAnswers.toInt() in GOOD_KNOWLEDGE_LEVEL..PERFECT_KNOWLEDGE_LEVEL) {
            cubIcon.setImageResource(R.drawable.win_silver)
            description.text = getString(R.string.user_description_good)
        } else {
            cubIcon.setImageResource(R.drawable.sad_dog)
            description.text = getString(R.string.user_description_poor)
        }
        score.text = "Your Score is \n$totalCorrectAnswers out of $totalQuestion"
    }

    private fun initViews() {
        cubIcon = binding.cubIcon
        score = binding.userScore
        description = binding.userDescription
        totalCorrectAnswers = requireArguments().getString("result", "0")
    }

}