package com.fbis.rickandmorty.api

import com.fbis.rickandmorty.api.dto.CharacterDetailDto
import com.fbis.rickandmorty.api.dto.CharactersDto
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {
    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int) : Response<CharactersDto>

    @GET("character/{id}")
    suspend fun getCharacterDetails(@Path("id") characterId: Int) : Response<CharacterDetailDto>
}
