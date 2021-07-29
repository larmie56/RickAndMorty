package com.fbis.rickandmorty.di

import com.fbis.rickandmorty.ui.CharacterDetailFragment
import com.fbis.rickandmorty.ui.CharacterListFragment
import com.fbis.rickandmorty.ui.MainActivity
import dagger.Component
import javax.inject.Singleton
import kotlin.reflect.KClass

@Component(modules = [Binder::class, NetworkModule::class])
@MainActivityScope
@Singleton
interface AppComponent {
    fun injectMainActivity(mainActivity: MainActivity)
    fun injectCharacterListFragment(characterListFragment: CharacterListFragment)
    fun injectCharacterDetailFragment(characterDetailFragment: CharacterDetailFragment)
}