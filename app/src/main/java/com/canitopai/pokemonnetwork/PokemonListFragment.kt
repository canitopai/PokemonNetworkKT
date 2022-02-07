package com.canitopai.pokemonnetwork

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.canitopai.pokemonnetwork.databinding.FragmentPokemonListBinding
import com.canitopai.pokemonnetwork.model.PokemonInfo
import com.canitopai.pokemonnetwork.model.PokemonResponse
import com.canitopai.pokemonnetwork.network.GetPokemon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//url base api: https://randomuser.me/api/
class PokemonListFragment : Fragment() {
    private var _binding: FragmentPokemonListBinding? = null
    private val binding
        get() = _binding!!
    private val adapter = UserAdapter {

        // var myDate: String = it.dob.date.substring(0, 10)
        //var myAgeShow: Int = it.dob.age
        //var myAge: String = myAgeShow.toString()

        val action = PokemonListFragmentDirections.actionPokemonListToPokemonDetailFragment(it.name,it.url
        )
        findNavController().navigate(action)
        //val action = PokemonListFragmentDirections.actionPokemonListToPokemonDetailFragment(it.name,it.types.type.name[0],it.height,it.weight,it.id
        //)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvPokemon.layoutManager = GridLayoutManager(context, 2)
        binding.rvPokemon.adapter = adapter

        requestData()
    }

    private fun requestData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/pokemon/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: GetPokemon = retrofit.create(GetPokemon::class.java)

        service.getPkmns().enqueue(object : Callback<PokemonInfo> {


            override fun onFailure(call: Call<PokemonInfo>, t: Throwable) {
                Toast.makeText(context, "Algo no ha funcionado como esperábamos", Toast.LENGTH_SHORT).show()
                Log.e("Retrofit", "Error: ${t.localizedMessage}", t)
            }

            override fun onResponse(call: Call<PokemonInfo>, response: Response<PokemonInfo>) {
                if (response.isSuccessful){
                    adapter.submitList(response.body()?.results)
                    Log.e("Retrofit","Salió bien")
                } else {
                    Toast.makeText(context, "400", Toast.LENGTH_SHORT).show()
                }
            }

        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}