package com.fbis.rickandmorty.mapper

interface RemoteMapper<in D, out E> {

    fun mapFromDTO(dto: D): E
    fun mapModelList(dtos: List<D>?): List<E> {
        return dtos?.mapTo(mutableListOf(), ::mapFromDTO) ?: emptyList()
    }
}