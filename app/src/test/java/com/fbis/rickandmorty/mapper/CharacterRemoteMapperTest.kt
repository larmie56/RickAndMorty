package com.fbis.rickandmorty.mapper

import org.junit.Test

import com.google.common.truth.Truth.assertThat

class CharacterRemoteMapperTest {

    @Test
    fun `verify mapFromDTO returns the correct data`() {
        val characterDetailDto = DummyData.morty

        val character = CharacterRemoteMapper.mapFromDTO(characterDetailDto)

        assertThat(characterDetailDto.id).isEqualTo(character.id)
        assertThat(characterDetailDto.name).isEqualTo(character.name)
        assertThat(characterDetailDto.image).isEqualTo(character.image)
    }

    @Test
    fun `verify mapModelList returns the correct data`() {
        val characterDtos = DummyData.charactersDTO.results

        val characters = CharacterRemoteMapper.mapModelList(characterDtos)

        assertThat(characterDtos[0].id).isEqualTo(characters[0].id)
        assertThat(characterDtos[0].name).isEqualTo(characters[0].name)

        assertThat(characterDtos[1].id).isEqualTo(characters[1].id)
        assertThat(characterDtos[1].name).isEqualTo(characters[1].name)
    }
}