package com.fbis.rickandmorty.mapper

import com.fbis.rickandmorty.api.dto.CharacterDetailDto
import com.fbis.rickandmorty.entity.Character

object CharacterRemoteMapper : RemoteMapper<CharacterDetailDto, Character> {
    override fun mapFromDTO(dto: CharacterDetailDto): Character {
        return Character(
            id = dto.id,
            name = dto.name,
            image = dto.image,
            status = dto.status,
            species = dto.species,
            origin = dto.origin.name,
            location = dto.origin.name
        )
    }
}