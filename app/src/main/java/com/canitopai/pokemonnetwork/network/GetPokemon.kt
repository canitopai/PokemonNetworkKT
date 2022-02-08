package com.canitopai.pokemonnetwork.network

import com.canitopai.pokemonnetwork.model.Pokemon
import com.canitopai.pokemonnetwork.model.PokemonInfo
import com.canitopai.pokemonnetwork.model.PokemonObject
import com.canitopai.pokemonnetwork.model.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url
import okhttp3.ResponseBody




interface GetPokemon {
    @GET("?offset=0&limit=200")
    fun getPkmns(): Call<PokemonInfo>

    @GET
    fun getPkmnDetailed(@Url url: String?): Call<PokemonObject?>?

}