package com.example.super_hero.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{
        private const val BASE_URL= "https://akabab.github.io/superhero-api/api/"
    fun getRetrofit():HeroAPI{
        val retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(HeroAPI::class.java)
    }
    }
}