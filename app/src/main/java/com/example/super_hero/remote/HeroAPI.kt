package com.example.super_hero.remote

import android.telecom.Call
import com.example.super_hero.remote.pojo.ResponseHeroItem
import retrofit2.Response
import retrofit2.http.GET

interface HeroAPI {
    @GET("all.json")
   suspend fun fetchHeroDataCoroutine():Response<List<ResponseHeroItem>>
}

