package com.canitopai.pokemonnetwork.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PokemonList (
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("url")
    @Expose
    val url: String
    )