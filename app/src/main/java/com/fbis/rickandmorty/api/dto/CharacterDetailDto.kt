package com.fbis.rickandmorty.api.dto

data class CharacterDetailDto(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginDto,
    val location: LocationDTO,
    val image: String,
    val episodes: List<String>?,
    val url: String,
    val created: String
)
