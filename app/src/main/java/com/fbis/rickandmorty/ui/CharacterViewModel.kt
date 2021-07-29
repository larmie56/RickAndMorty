package com.fbis.rickandmorty.ui

import android.util.Log
import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.fbis.rickandmorty.api.dto.CharacterDetailDto
import com.fbis.rickandmorty.api.dto.CharactersDto
import com.fbis.rickandmorty.entity.Character
import com.fbis.rickandmorty.mapper.CharacterRemoteMapper
import com.fbis.rickandmorty.repo.RemoteRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterViewModel(private val repo: RemoteRepo) : ViewModel() {

    private val _character = MutableLiveData<CharacterDetailDto>()

    val character: LiveData<Character> = Transformations.map(_character) { characterDetailsDto ->
        CharacterRemoteMapper.mapFromDTO(characterDetailsDto)
    }

    private val _characters = MutableLiveData<PagingData<Character>>()
    val characters: LiveData<PagingData<Character>>
        get() = _characters

    private val _networkError = MutableLiveData<String>()
    val networkError: LiveData<String>
        get() = _networkError

    fun getCharacters() : Flow<PagingData<Character>> {
        Log.d("Network call", "Network call launched")
        return repo.getCharacters().cachedIn(viewModelScope)
    }

    fun getCharacter(id: Int) {
        viewModelScope.launch {
            try {
                _character.value = repo.getCharacterDetail(id).body()
                Log.d("Network call", "Network result - ${repo.getCharacterDetail(id).body()}")
            } catch (exception: Exception) {
                _networkError.value = exception.message
                Log.d("Network call", "Network call failed ${exception.message}")
            }
        }
    }
}