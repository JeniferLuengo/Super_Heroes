package com.example.super_hero.remote.pojo


import com.google.gson.annotations.SerializedName

data class Powerstats(
    @SerializedName("combat")
    val combat: Int,
    @SerializedName("durability")
    val durability: Int,
    @SerializedName("intelligence")
    val intelligence: Int,
    @SerializedName("power")
    val power: Int,
    @SerializedName("speed")
    val speed: Int,
    @SerializedName("strength")
    val strength: Int
)