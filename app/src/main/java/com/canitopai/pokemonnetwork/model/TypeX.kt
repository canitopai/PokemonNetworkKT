package com.canitopai.pokemonnetwork.model


import com.google.gson.annotations.SerializedName

data class TypeX(
    @SerializedName("slot")
    val slot: Int,
    @SerializedName("type")
    val type: TypeXX
)