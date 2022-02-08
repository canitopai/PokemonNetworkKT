package com.canitopai.pokemonnetwork.model


import com.google.gson.annotations.SerializedName

data class TypeXX(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)