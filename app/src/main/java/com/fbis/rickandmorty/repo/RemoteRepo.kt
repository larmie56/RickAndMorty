package com.fbis.rickandmorty.repo

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.fbis.rickandmorty.api.dto.CharacterDetailDto
import com.fbis.rickandmorty.api.dto.CharactersDto
import com.fbis.rickandmorty.entity.Character
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response

interface RemoteRepo {

    fun getCharacters() : Flow<PagingData<Character>>
    suspend fun getCharacterDetail(id: Int) : Response<CharacterDetailDto>
}