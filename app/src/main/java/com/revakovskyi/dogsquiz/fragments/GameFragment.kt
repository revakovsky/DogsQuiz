package com.revakovskyi.dogsquiz.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.revakovskyi.dogsquiz.R
import com.revakovskyi.dogsquiz.databinding.FragmentGameBinding
import com.revakovskyi.dogsquiz.model.Question
import com.revakovskyi.dogsquiz.model.QuestionsList
import com.revakovskyi.dogsquiz.utils.AppearanceUtils
import com.revakovskyi.dogsquiz.utils.makeToast

class GameFragment : Fragment(R.layout.fragment_game) {

    private lateinit var binding: FragmentGameBinding
    private var questionsList: List<Question>? = null
    private var appearanceUtils: AppearanceUtils? = null

    private var questionId: Int = 1
    private lateinit var dogImage: ImageView
    private lateinit var fieldOption1: TextView
    private lateinit var fieldOption2: TextView
    private lateinit var fieldOption3: TextView
    private lateinit var fieldOption4: TextView
    private var correctAnswer: Int = 0

    private lateinit var progressBar: ProgressBar
    private lateinit var progressText: TextView

    private var currentQuestionNumber: Int = 1
    private var selectedOptionNumber: Int = 0
    private var optionsList = ArrayList<TextView>()
    private val maxAmountOfQuestions = QuestionsList.MAX_AMOUNT_OF_QUESTIONS
    private var totalCorrectAnswers: String = ""
    private var toast: Toast? = null

    private var counter = 1
    private var rightChoice = 0


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGameBinding.bind(view)

        initViews()
        createQuestion()
        setUpListenersForOptions()
        setButtonsAction()

    }

    private fun setUpListenersForOptions() {
        setUpListeners(fieldOption1, QuestionsList.CHOOSING_OPTION_1)
        setUpListeners(fieldOption2, QuestionsList.CHOOSING_OPTION_2)
        setUpListeners(fieldOption3, QuestionsList.CHOOSING_OPTION_3)
        setUpListeners(fieldOption4, QuestionsList.CHOOSING_OPTION_4)
    }

    private fun setUpListeners(fieldOption: TextView, choosingOption: Int) {
        fieldOption.setOnClickListener { selectedOptionLook(fieldOption, choosingOption) }
    }

    private fun initViews() {
        dogImage = binding.dogImage
        fieldOption1 = binding.optionOne
        fieldOption2 = binding.optionTwo
        fieldOption3 = binding.optionThree
        fieldOption4 = binding.optionFour
        progressBar = binding.progressBar
        progressText = binding.progressText

        appearanceUtils = AppearanceUtils(requireActivity())
        optionsList = createOptionsList(fieldOption1, fieldOption2, fieldOption3, fieldOption4)
    }

    @SuppressLint("SetTextI18n")
    private fun createQuestion() {
        if (currentQuestionNumber == maxAmountOfQuestions + 1) showNextScreen()

        questionsList = QuestionsList(requireContext()).getQuestions()
        val question = questionsList!![currentQuestionNumber - 1]

        progressBar.progress = currentQuestionNumber
        progressText.text = "$currentQuestionNumber/${progressBar.max}"

        questionId = question.qId
        dogImage.setImageResource(question.dogImage)
        fieldOption1.text = question.opt1
        fieldOption2.text = question.opt2
        fieldOption3.text = question.opt3
        fieldOption4.text = question.opt4
        correctAnswer = question.correctAnswer
    }

    private fun createOptionsList(
        fieldOption1: TextView,
        fieldOption2: TextView,
        fieldOption3: TextView,
        fieldOption4: TextView
    ): ArrayList<TextView> {

        return arrayListOf(
            fieldOption1,
            fieldOption2,
            fieldOption3,
            fieldOption4,
        )
    }

    private fun setUpAction() {
        if (questionId != currentQuestionNumber) selectedOptionNumber = 0
        if (selectedOptionNumber == 0) showNewQuestions()
        else checkAnswer()
    }

    private fun showNewQuestions() {
        createQuestion()
        appearanceUtils?.setDefaultOptionLook(optionsList)
        appearanceUtils?.makeOptionsClickable(optionsList)
        chooseButtonText()

        if (appearanceUtils?.isOptionActivated(optionsList) == true) {
            currentQuestionNumber++
            selectedOptionNumber = 0
            counter++
            chooseButtonText()

        } else {
            toast?.cancel()
            askToChooseSomething()
        }
    }

    private fun checkAnswer() {
        val question = questionsList?.get(currentQuestionNumber - 1)

        question?.let { checkAnswerWithSelected(it.correctAnswer) }
        chooseButtonText()

        currentQuestionNumber++
        selectedOptionNumber = 0
    }

    private fun checkAnswerWithSelected(correctAnswer: Int) {
        if (correctAnswer != selectedOptionNumber) {
            appearanceUtils?.setAnsweredOptionLook(
                answer = selectedOptionNumber,
                drawableResource = R.drawable.incorrect_option_bg,
                optionsList = optionsList
            )
        } else {
            rightChoice++
        }
        appearanceUtils?.setAnsweredOptionLook(
            correctAnswer,
            R.drawable.correct_option_bg,
            optionsList
        )
        appearanceUtils?.makeOptionsUnclickable(optionsList)
    }

    private fun selectedOptionLook(fieldOption: TextView, optionNumber: Int) {
        appearanceUtils?.setDefaultOptionLook(optionsList)
        selectedOptionNumber = optionNumber
        appearanceUtils?.setStyle(fieldOption, R.drawable.selected_option_bg)
    }

    private fun askToChooseSomething() {
        if (counter == currentQuestionNumber) {
            toast = makeToast(R.string.make_choice)
            toast?.show()
        }
        counter = questionId
    }

    private fun showNextScreen() {
        currentQuestionNumber = 1
        questionId = 1

        findNavController().navigate(
            R.id.action_gameFragment_to_resultsFragment,
            bundleOf("result" to totalCorrectAnswers)
        )
    }

    private fun setButtonsAction() {
        binding.apply {
            submitButton.setOnClickListener { setUpAction() }

            backToMenuButton.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun chooseButtonText() {
        if (selectedOptionNumber == 0) {
            binding.submitButton.text = getString(R.string.submit)
        } else if (currentQuestionNumber >= (questionsList?.size ?: questionId)) {
            binding.submitButton.text = getString(R.string.finish_quiz)
            totalCorrectAnswers = rightChoice.toString()
        } else {
            binding.submitButton.text = getString(R.string.next_question)
        }
    }

    override fun onDetach() {
        super.onDetach()
        questionsList = null
        appearanceUtils = null
    }

}