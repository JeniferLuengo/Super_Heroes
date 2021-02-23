package com.example.super_hero.remote

import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.super_hero.databinding.ItemHeroListBinding

class HeroAdapter : RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {

    private var heroList = emptyList<SuperHero>()
    private val selectedHero = MutableLiveData<SuperHero>()

    fun selectedItem(): LiveData<SuperHero> = selectedHero
    fun update(list: List<SuperHero>) {
        heroList = list
        notifyDataSetChanged()
    }

    inner class HeroViewHolder(private val binding: ItemHeroListBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        fun bind(hero: SuperHero) {

            binding.textViewName.text = hero.name
            Glide.with(binding.Imagev1).load(hero.images).into(binding.Imagev1)
            itemView.setOnClickListener(this)

        }

        override fun onClick(v: View?) {
            selectedHero.value = heroList[adapterPosition]


        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        return HeroViewHolder(ItemHeroListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: HeroAdapter.HeroViewHolder, position: Int) {
        holder.bind(heroList[position])
    }


    override fun getItemCount() = heroList.size


}