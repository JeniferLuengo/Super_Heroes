package com.example.super_hero.remote

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull

@Entity(tableName="task_table")
data class SuperHero(
    @PrimaryKey
    @NotNull
    @SerializedName("id")
    val id: Int, //1
    @SerializedName("name")
    val name: String,//"A-Bomb"
    @SerializedName("fullName")
    val fullName: String,// nombre completo
    @SerializedName("aliases")
    val aliases: String, //alias
    @SerializedName("images")
    val images:String)//url imagen