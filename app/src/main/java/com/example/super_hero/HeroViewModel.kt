package com.example.super_hero

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.super_hero.remote.SuperHero
import com.example.super_hero.remote.pojo.HeroDataBase
import com.example.super_hero.remote.pojo.HeroRepository
import kotlinx.coroutines.launch

class HeroViewModel(application: Application):
AndroidViewModel(application){

    private val repository:HeroRepository
    init{
        val db = HeroDataBase.getDataBase(application)
        val HeroDAO= db.heroDao()
        repository= HeroRepository(HeroDAO)
        viewModelScope.launch {
            repository.fetchHero()
        }
    }
    fun getHeroList(): LiveData<List<SuperHero>> = repository.heroListLiveData
    fun getHeroById(id:Int):LiveData<SuperHero>{
        return repository.getHeroById(id)
    }
}