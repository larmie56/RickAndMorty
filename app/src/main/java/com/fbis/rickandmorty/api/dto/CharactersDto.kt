package com.fbis.rickandmorty.api.dto

data class CharactersDto(
    val info: InfoDto,
    val results: List<CharacterDetailDto>
)
