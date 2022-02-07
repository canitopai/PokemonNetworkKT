package com.canitopai.pokemonnetwork.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Pokemon(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("height")
    @Expose
    val height: Float,
    @SerializedName("weight")
    @Expose
    val weight: Float,
    @SerializedName("types")
    @Expose
    val types: Array<String>,
    @SerializedName("sprite")
    @Expose
    val sprite: Sprite
)
