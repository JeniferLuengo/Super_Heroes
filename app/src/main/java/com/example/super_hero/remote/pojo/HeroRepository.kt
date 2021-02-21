package com.example.super_hero.remote.pojo

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.super_hero.fromInternetToheroEntity
import com.example.super_hero.remote.RetrofitClient
import com.example.super_hero.remote.SuperHero
import com.example.super_hero.view_model.HeroDAO

class HeroRepository (private val heroDao : HeroDAO ) {
    val heroInternet = heroDao.getAllHero()

    private val networkService =  RetrofitClient.getRetrofit()

    val heroListLiveData = heroDao.getAllHero() // devuelve el listado

    suspend fun fetchHero(){ // busca Heroe
        val service = kotlin.runCatching { networkService .
        fetchHeroDataCoroutine()}
        service.onSuccess {
            when (it.code()){
                200 -> it.body()?.let{
                    heroDao.insertAllHero(
                        fromInternetToheroEntity(it))
                }
                else-> Log.d("REPO", "$[it.code()} - " +
                        "${it.errorBody()}")
            }
            service.onFailure {
                Log.e("REPO", "${it.message}")
            }
        }
    }
    fun getHeroById(id:Int): LiveData<SuperHero> {
        return heroDao.getHeroById(id)
    }
}