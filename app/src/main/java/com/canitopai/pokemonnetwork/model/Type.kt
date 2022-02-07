package com.canitopai.pokemonnetwork.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Type(
    @SerializedName("name")
    @Expose
    val name: String
)
