package com.canitopai.pokemonnetwork


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.canitopai.pokemonnetwork.databinding.PokemonItemBinding
import com.canitopai.pokemonnetwork.model.Pokemon
import com.canitopai.pokemonnetwork.model.PokemonInfo
import com.canitopai.pokemonnetwork.model.PokemonList

interface onUserListener {
    fun onClick(pkmn: Pokemon)
}

class UserAdapter(private val onUserClicked: (PokemonList) -> Unit): ListAdapter<PokemonList, UserAdapter.ViewHolder>(UserItemCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: PokemonItemBinding = PokemonItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pkmn = getItem(position)
        //var myTipo = ""
        //for (i in 0 until pkmn.types.size){
          //  myTipo = myTipo+", "+pkmn.types.get(i)
        //}
        holder.binding.txtName.text = pkmn.name
        holder.binding.txtUrl.text = pkmn.url
        //holder.binding.txtType.text = myTipo
        //Picasso.get()
          //  .load(pkmn.sprite.front_default)
            //.placeholder(R.drawable.ic_launcher_foreground)
            //.into(holder.binding.imageView)



        holder.binding.root.setOnClickListener {
            onUserClicked(pkmn)
        }
    }

    inner class ViewHolder(val binding: PokemonItemBinding): RecyclerView.ViewHolder(binding.root)


}

class UserItemCallback: DiffUtil.ItemCallback<PokemonList>(){
    override fun areItemsTheSame(oldItem: PokemonList, newItem: PokemonList): Boolean = oldItem.url == newItem.url

    override fun areContentsTheSame(oldItem: PokemonList, newItem: PokemonList): Boolean = oldItem.url == newItem.url

}

