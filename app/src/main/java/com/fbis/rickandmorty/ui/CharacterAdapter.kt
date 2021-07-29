package com.fbis.rickandmorty.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fbis.rickandmorty.api.dto.CharacterDetailDto
import com.fbis.rickandmorty.api.dto.CharactersDto
import com.fbis.rickandmorty.databinding.CharacterListItemBinding
import com.fbis.rickandmorty.entity.Character

class CharacterAdapter(
    private val clickListener: ClickListener,
) : PagingDataAdapter<Character, CharacterAdapter.CharacterViewHolder>(CharacterDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let { character ->
            holder.bind(character, clickListener)
        }
    }

    class CharacterViewHolder(private val binding: CharacterListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): CharacterViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding: CharacterListItemBinding = CharacterListItemBinding.inflate(
                    inflater,
                    parent,
                    false
                )
                return CharacterViewHolder(binding)
            }
        }

        fun bind(character: Character, clickListener: ClickListener) {
            itemView.setOnClickListener { clickListener.clickListener(character.id) }
            Glide.with(binding.imageviewCharacter)
                .load(character.image)
                .into(binding.imageviewCharacter)
            binding.textName.text = character.name
        }
    }

    class CharacterDiffUtilCallback : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem == newItem
        }

    }

    class ClickListener(val listener: (Int) -> Unit) {
        fun clickListener(id: Int) = listener(id)
    }
}