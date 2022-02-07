package com.canitopai.pokemonnetwork.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PokemonInfo(
    @SerializedName("count")
    @Expose
    val count: Int,
    @SerializedName("next")
    @Expose
    val next: String,
    @SerializedName("previous")
    @Expose
    val previous: String,
    @SerializedName("results")
    @Expose
    val results: MutableList<PokemonList>

)
