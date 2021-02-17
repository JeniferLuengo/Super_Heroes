package com.example.super_hero.remote.pojo


import com.google.gson.annotations.SerializedName

data class Appearance(
    @SerializedName("eyeColor")
    val eyeColor: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("hairColor")
    val hairColor: String,
    @SerializedName("height")
    val height: List<String>,
    @SerializedName("race")
    val race: Any,
    @SerializedName("weight")
    val weight: List<String>
)