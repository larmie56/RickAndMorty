package com.fbis.rickandmorty.entity

data class Character(
    val id: Int,
    val name: String,
    val image: String,
    val status: String,
    val species: String,
    val origin: String,
    val location: String
)
