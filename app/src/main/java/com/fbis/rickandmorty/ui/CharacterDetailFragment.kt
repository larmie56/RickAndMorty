package com.fbis.rickandmorty.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.fbis.rickandmorty.App
import com.fbis.rickandmorty.databinding.FragmentCharacterDetailBinding
import javax.inject.Inject

class CharacterDetailFragment : Fragment() {

    lateinit var binding: FragmentCharacterDetailBinding
    @Inject
    lateinit var characterViewModelFactory: CharacterViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterDetailBinding.inflate(layoutInflater, container, false)

        val app = activity?.application as App
        app.appComponent.injectCharacterDetailFragment(this)

        val characterViewModel = ViewModelProvider(requireActivity(), characterViewModelFactory)
            .get(CharacterViewModel::class.java)

        val id = CharacterDetailFragmentArgs.fromBundle(requireArguments()).id

        characterViewModel.getCharacter(id)

        characterViewModel.character.observe(viewLifecycleOwner, { character ->
            Glide.with(binding.imageviewCharacter)
                .load(character.image)
                .into(binding.imageviewCharacter)
            binding.textName.text = character.name
            binding.textStatus.text = character.status
            binding.textSpecies.text = character.species
            binding.textOrigin.text = character.origin
            binding.textLocation.text = character.location
        })

        return binding.root
    }
}