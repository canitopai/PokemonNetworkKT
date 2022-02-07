package com.canitopai.pokemonnetwork.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Sprite(
    @SerializedName("front_default")
    @Expose
    val front_default: String,
)
