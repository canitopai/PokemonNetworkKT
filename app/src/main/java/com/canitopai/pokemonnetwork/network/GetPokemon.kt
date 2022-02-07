package com.canitopai.pokemonnetwork.network

import com.canitopai.pokemonnetwork.model.Pokemon
import com.canitopai.pokemonnetwork.model.PokemonInfo
import com.canitopai.pokemonnetwork.model.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET

interface GetPokemon {
    @GET("?offset=30&limit=50")
    fun getPkmns(): Call<PokemonInfo>
    @GET()
    fun getPkmnDetailed(): Call<Pokemon>
}