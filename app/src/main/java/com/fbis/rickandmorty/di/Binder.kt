package com.fbis.rickandmorty.di

import com.fbis.rickandmorty.repo.CharacterRemoteRepo
import com.fbis.rickandmorty.repo.RemoteRepo
import dagger.Binds
import dagger.Module

@Module
interface Binder {

    @Binds
    fun providesCharacterRemoteRepo(characterRemoteRepo: CharacterRemoteRepo) : RemoteRepo
}