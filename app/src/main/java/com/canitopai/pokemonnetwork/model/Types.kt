package com.canitopai.pokemonnetwork.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Types(
    @SerializedName("slot")
    @Expose
    val slot: Int,
    @SerializedName("type")
    @Expose
    val type: Type
)

