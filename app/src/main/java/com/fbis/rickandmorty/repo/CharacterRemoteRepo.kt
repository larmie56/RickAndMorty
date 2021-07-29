package com.fbis.rickandmorty.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.fbis.rickandmorty.api.CharacterApiService
import com.fbis.rickandmorty.api.dto.CharacterDetailDto
import com.fbis.rickandmorty.api.dto.CharactersDto
import com.fbis.rickandmorty.entity.Character
import com.fbis.rickandmorty.paging.CharacterDataSource
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class CharacterRemoteRepo @Inject constructor(private val apiService: CharacterApiService) :
    RemoteRepo {
    override fun getCharacters(): Flow<PagingData<Character>> {
        Log.d("Network call", "Network pager created")
        val result = Pager(PagingConfig(pageSize = 34, enablePlaceholders = false),
            pagingSourceFactory = {
                CharacterDataSource(apiService)
            }).flow
        Log.d("Network call", "Network pager completed - $result")
        return result
    }

    override suspend fun getCharacterDetail(id: Int): Response<CharacterDetailDto> {
        return apiService.getCharacterDetails(id)
    }
}