package com.fbis.rickandmorty.api.dto

data class InfoDto(
    val count: String,
    val pages: String,
    val next: String?,
    val prev: String?
)
