package com.revakovskyi.dogsquiz.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.revakovskyi.dogsquiz.R
import com.revakovskyi.dogsquiz.model.QuestionsList.Companion.CHOOSING_OPTION_1
import com.revakovskyi.dogsquiz.model.QuestionsList.Companion.CHOOSING_OPTION_2
import com.revakovskyi.dogsquiz.model.QuestionsList.Companion.CHOOSING_OPTION_3
import com.revakovskyi.dogsquiz.model.QuestionsList.Companion.CHOOSING_OPTION_4

class AppearanceUtils(private val context: Context) {

    fun setDefaultOptionLook(optionsList: List<TextView>) {
        for (option in optionsList) {
            option.background = getOptionBackground(R.drawable.option_bg)
        }
    }

    fun setStyle(fieldOption: TextView, drawableResource: Int) {
        fieldOption.background = getOptionBackground(drawableResource)
    }

    private fun getOptionBackground(drawableResource: Int): Drawable? {
        return ResourcesCompat.getDrawable(
            context.resources, drawableResource, null
        )
    }

    fun setAnsweredOptionLook(answer: Int, drawableResource: Int, optionsList: List<TextView>) {
        when (answer) {
            CHOOSING_OPTION_1 -> setStyle(optionsList[CHOOSING_OPTION_1 - 1], drawableResource)
            CHOOSING_OPTION_2 -> setStyle(optionsList[CHOOSING_OPTION_2 - 1], drawableResource)
            CHOOSING_OPTION_3 -> setStyle(optionsList[CHOOSING_OPTION_3 - 1], drawableResource)
            CHOOSING_OPTION_4 -> setStyle(optionsList[CHOOSING_OPTION_4 - 1], drawableResource)
        }
    }

    fun isOptionActivated(optionsList: List<TextView>): Boolean {
        return optionsList[CHOOSING_OPTION_1 - 1].isActivated ||
                optionsList[CHOOSING_OPTION_2 - 1].isActivated ||
                optionsList[CHOOSING_OPTION_3 - 1].isActivated ||
                optionsList[CHOOSING_OPTION_4 - 1].isActivated
    }

}