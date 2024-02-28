package com.shyam.interview_shyam.Model

data class Therapies(
    val `data`: List<Data>,
    val message: String,
    val status: Int,
    val success: Boolean,
    val token: String
)