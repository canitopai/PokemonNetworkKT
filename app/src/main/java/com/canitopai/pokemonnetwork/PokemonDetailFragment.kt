package com.canitopai.pokemonnetwork

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.canitopai.pokemonnetwork.databinding.FragmentPokemonDetailBinding
import com.canitopai.pokemonnetwork.model.Pokemon
import com.canitopai.pokemonnetwork.model.PokemonInfo
import com.canitopai.pokemonnetwork.model.PokemonObject
import com.canitopai.pokemonnetwork.network.GetPokemon
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_pokemon_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.KProperty



class PokemonDetailFragment : Fragment() {
    private var _binding: FragmentPokemonDetailBinding? = null
    private val binding
        get() = _binding!!

    private val args: PokemonDetailFragmentArgs by navArgs()
    private var name: String? = null
    private var type: String? = null
    private var weight: Float? = null
    private var height: Float? = null
    private var mid: Int = 0
    private var sprite: String? = null
    private var url: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestData()
        binding.txtDetailName.text = name
        binding.txtDetailHeight.text = height.toString()
        binding.txtDetailWeight.text = weight.toString()
        binding.txtDetailType.text = type
        binding.txtDetailId.text = id.toString()
        Picasso.get()
            .load(sprite)
            .into(binding.imageView2)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            url = it.getString("url")
            //name = it.getString("name")
           // type = it.getString("type")
            //height = it.getFloat("height")
            //weight = it.getFloat("weight")
            //mid = it.getInt("id")
            //sprite = it.getString("picture")
        }
    }

    private fun requestData() {
        val retrofit = Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/pokemon/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: GetPokemon = retrofit.create(GetPokemon::class.java)

        service.getPkmnDetailed(url)?.enqueue(object : Callback<PokemonObject?> {


            override fun onFailure(call: Call<PokemonObject?>, t: Throwable) {
                Toast.makeText(context, "Algo no ha funcionado como esper??bamos", Toast.LENGTH_SHORT).show()
                Log.e("Retrofit", "Error: ${t.localizedMessage}", t)
            }

            override fun onResponse(call: Call<PokemonObject?>, response: Response<PokemonObject?>) {
                if (response.isSuccessful){
                    var myType: String = " "
                    txtDetailName.text = response.body()?.name
                    txtDetailHeight.text = response.body()?.height.toString()
                    txtDetailWeight.text = response.body()?.weight.toString()
                    for(i in 0 until (response.body()?.types?.size ?: 0)){
                        myType = myType+ (response.body()?.types?.get(i)?.type?.name ?: "null")+", "
                    }
                    txtDetailType.text = myType
                    txtDetailId.text = response.body()?.id.toString()
                    Picasso.get()
                        .load(response.body()?.sprites?.frontDefault)
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .into(imageView2)
                    Log.e("Retrofit","Sali?? bien")
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


