package com.example.super_hero

import com.example.super_hero.remote.SuperHero
import com.example.super_hero.remote.pojo.ResponseHeroItem
import java.sql.Wrapper

fun fromInternetToheroEntity(listadosuper: List<ResponseHeroItem>):List<SuperHero>{
    return listadosuper.map {
        SuperHero(id = it.id,name = it.name,fullName = it.biography.fullName,aliases = it.biography.aliases[0],images = it.images.lg)

    }
}