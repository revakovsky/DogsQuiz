package com.revakovskyi.dogsquiz.model

import android.content.Context
import com.revakovskyi.dogsquiz.R

class QuestionsList(context: Context) {

    private val question1 = Question(
        qId = 1,
        dogImage = R.drawable.dog1_beagle,
        opt1 = context.getString(R.string.option1_1),
        opt2 = context.getString(R.string.option1_2),
        opt3 = context.getString(R.string.option1_3),
        opt4 = context.getString(R.string.option1_4),
        correctAnswer = context.resources.getInteger(R.integer.correct_answer1)
    )

    private val question2 = Question(
        qId = 2,
        dogImage = R.drawable.dog2_belgian_shepherd_malinois,
        opt1 = context.getString(R.string.option2_1),
        opt2 = context.getString(R.string.option2_2),
        opt3 = context.getString(R.string.option2_3),
        opt4 = context.getString(R.string.option2_4),
        correctAnswer = context.resources.getInteger(R.integer.correct_answer2)
    )

    private val question3 = Question(
        qId = 3,
        dogImage = R.drawable.dog3_bolognese,
        opt1 = context.getString(R.string.option3_1),
        opt2 = context.getString(R.string.option3_2),
        opt3 = context.getString(R.string.option3_3),
        opt4 = context.getString(R.string.option3_4),
        correctAnswer = context.resources.getInteger(R.integer.correct_answer3)
    )

    private val question4 = Question(
        qId = 4,
        dogImage = R.drawable.dog4_boxer,
        opt1 = context.getString(R.string.option4_1),
        opt2 = context.getString(R.string.option4_2),
        opt3 = context.getString(R.string.option4_3),
        opt4 = context.getString(R.string.option4_4),
        correctAnswer = context.resources.getInteger(R.integer.correct_answer4)
    )

    private val question5 = Question(
        qId = 5,
        dogImage = R.drawable.dog5_bull_terrier,
        opt1 = context.getString(R.string.option5_1),
        opt2 = context.getString(R.string.option5_2),
        opt3 = context.getString(R.string.option5_3),
        opt4 = context.getString(R.string.option5_4),
        correctAnswer = context.resources.getInteger(R.integer.correct_answer5)
    )

    private val question6 = Question(
        qId = 6,
        dogImage = R.drawable.dog6_bulldog,
        opt1 = context.getString(R.string.option6_1),
        opt2 = context.getString(R.string.option6_2),
        opt3 = context.getString(R.string.option6_3),
        opt4 = context.getString(R.string.option6_4),
        correctAnswer = context.resources.getInteger(R.integer.correct_answer6)
    )

    private val question7 = Question(
        qId = 7,
        dogImage = R.drawable.dog7_chihuahua_long_coat,
        opt1 = context.getString(R.string.option7_1),
        opt2 = context.getString(R.string.option7_2),
        opt3 = context.getString(R.string.option7_3),
        opt4 = context.getString(R.string.option7_4),
        correctAnswer = context.resources.getInteger(R.integer.correct_answer7)
    )

    private val question8 = Question(
        qId = 8,
        dogImage = R.drawable.dog8_chow_chow_rough,
        opt1 = context.getString(R.string.option8_1),
        opt2 = context.getString(R.string.option8_2),
        opt3 = context.getString(R.string.option8_3),
        opt4 = context.getString(R.string.option8_4),
        correctAnswer = context.resources.getInteger(R.integer.correct_answer8)
    )

    private val question9 = Question(
        qId = 9,
        dogImage = R.drawable.dog9_mastiff,
        opt1 = context.getString(R.string.option9_1),
        opt2 = context.getString(R.string.option9_2),
        opt3 = context.getString(R.string.option9_3),
        opt4 = context.getString(R.string.option9_4),
        correctAnswer = context.resources.getInteger(R.integer.correct_answer9)
    )

    private val question10 = Question(
        qId = 10,
        dogImage = R.drawable.dog10_pug,
        opt1 = context.getString(R.string.option10_1),
        opt2 = context.getString(R.string.option10_2),
        opt3 = context.getString(R.string.option10_3),
        opt4 = context.getString(R.string.option10_4),
        correctAnswer = context.resources.getInteger(R.integer.correct_answer10)
    )

    fun getQuestions(): List<Question> {
        return listOf(
            question1,
            question2,
            question3,
            question4,
            question5,
            question6,
            question7,
            question8,
            question9,
            question10
        )
    }

    companion object {
        const val MAX_AMOUNT_OF_QUESTIONS = 10

        const val CHOOSING_OPTION_1 = 1
        const val CHOOSING_OPTION_2 = 2
        const val CHOOSING_OPTION_3 = 3
        const val CHOOSING_OPTION_4 = 4
    }

}