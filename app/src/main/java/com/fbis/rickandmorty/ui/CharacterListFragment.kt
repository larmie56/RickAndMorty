package com.fbis.rickandmorty.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.fbis.rickandmorty.App
import com.fbis.rickandmorty.databinding.FragmentCharacterListBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterListFragment : Fragment() {

    lateinit var binding: FragmentCharacterListBinding

    @Inject
    lateinit var characterViewModelFactory: CharacterViewModelFactory

    private val characterViewModel by lazy {
        ViewModelProvider(requireActivity(), characterViewModelFactory)
            .get(CharacterViewModel::class.java)
    }
    private val characterAdapter by lazy {
        CharacterAdapter(CharacterAdapter.ClickListener { id ->
            findNavController().navigate(
                CharacterListFragmentDirections
                    .actionCharacterListFragmentToCharacterDetailFragment(id)
            )
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterListBinding.inflate(inflater, container, false)

        val app = activity?.application as App
        app.appComponent.injectCharacterListFragment(this)

        Log.d("Network call", "Network call started")
        viewLifecycleOwner.lifecycleScope.launch {
            characterViewModel.getCharacters().collectLatest { characters ->
                characterAdapter.submitData(characters)
            }
        }

        characterAdapter.addLoadStateListener {
            if (it.refresh == LoadState.Loading) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }

        }

        binding.recyclerCharacters.adapter = characterAdapter

        return binding.root
    }
}