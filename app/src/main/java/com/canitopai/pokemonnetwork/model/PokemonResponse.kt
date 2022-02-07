package com.canitopai.pokemonnetwork.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("results")
    @Expose
    val pokemon: List<Pokemon>
)
