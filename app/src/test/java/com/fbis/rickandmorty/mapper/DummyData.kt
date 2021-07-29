package com.fbis.rickandmorty.mapper

import com.fbis.rickandmorty.api.dto.*

object DummyData {

    val info = InfoDto(
        "5",
        "9",
        "https://rickandmortyapi.com/api/character?page=1",
        "https://rickandmortyapi.com/api/character?page=3"
    )
    val originDto = OriginDto("Earth", "https://rickandmortyapi.com/api/location/1")
    val locationDTO = LocationDTO("Earth", "https://rickandmortyapi.com/api/location/1")

    val morty = CharacterDetailDto(
        2,
        "Morty",
        "Alive",
        "Human",
        "",
        "Male",
        originDto,
        locationDTO,
        "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
        mutableListOf("Episode 1", "Episode 2", "Episode 3"),
        "https://rickandmortyapi.com/api/character/2",
        "1st Jan 2020"
    )

    val summer = CharacterDetailDto(
        3,
        "Summer",
        "Alive",
        "Human",
        "Regular",
        "Female",
        originDto,
        locationDTO,
        "https://rickandmortyapi.com/api/character/avatar/3.jpeg",
        mutableListOf("Episode 1", "Episode 2", "Episode 3"),
        "https://rickandmortyapi.com/api/character/3",
        "1st Jan 2020"
    )

    val beth = CharacterDetailDto(
        4,
        "Beth",
        "Alive",
        "Human",
        "Regular",
        "Female",
        originDto,
        locationDTO,
        "https://rickandmortyapi.com/api/character/avatar/4.jpeg",
        mutableListOf("Episode 1", "Episode 2", "Episode 3"),
        "https://rickandmortyapi.com/api/character/4",
        "1st Jan 2020"
    )

    val charactersDTO = CharactersDto(info = info, mutableListOf(morty, summer, beth))
}