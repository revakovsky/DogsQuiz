package com.revakovskyi.dogsquiz.model

data class Question(
    val qId: Int,
    val dogImage: Int,

    val opt1: String,
    val opt2: String,
    val opt3: String,
    val opt4: String,

    val correctAnswer: Int
)
