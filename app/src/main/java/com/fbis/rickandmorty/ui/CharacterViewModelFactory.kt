package com.fbis.rickandmorty.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fbis.rickandmorty.repo.CharacterRemoteRepo
import javax.inject.Inject

class CharacterViewModelFactory @Inject constructor(private val repo: CharacterRemoteRepo) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterViewModel::class.java)) {
            return CharacterViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}