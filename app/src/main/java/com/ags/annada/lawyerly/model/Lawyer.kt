package com.ags.annada.lawyerly.model

data class Lawyer constructor(val id: Int,
                              val name: String,
                              val speciality: String,
                              val image: String,
                              val rating: Float,
                              val price: String,
                              val verified: Boolean)