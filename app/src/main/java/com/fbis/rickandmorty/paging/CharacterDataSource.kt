package com.fbis.rickandmorty.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.fbis.rickandmorty.api.CharacterApiService
import com.fbis.rickandmorty.entity.Character
import com.fbis.rickandmorty.mapper.CharacterRemoteMapper

class CharacterDataSource(private val apiService: CharacterApiService) :
    PagingSource<Int, Character>() {
    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try {
            val currentPage = params.key ?: INITIAL_PAGE
            val response = apiService.getCharacters(currentPage).body()?.results
            val characters = CharacterRemoteMapper.mapModelList(response)

            LoadResult.Page(characters, null, currentPage + 1)
        } catch (exception: Exception) {
            Log.d("Network call", "Network call failed - ${exception.message}")
            LoadResult.Error(exception)
        }
    }

    companion object {
        const val INITIAL_PAGE: Int = 1
    }
}