package com.fbis.rickandmorty.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.fbis.rickandmorty.App
import com.fbis.rickandmorty.R
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var characterViewModelFactory: CharacterViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val app: App = application as App

        app.appComponent.injectMainActivity(this)

        val viewModel = ViewModelProvider(this, characterViewModelFactory)
            .get(CharacterViewModel::class.java)

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)

        return (navController.navigateUp() || super.onSupportNavigateUp())
    }
}