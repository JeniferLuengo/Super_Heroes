package com.example.super_hero.view_model

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.super_hero.remote.SuperHero

@Dao
interface HeroDAO {


    //Insertar lista de tarea
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllHero(listHero:List<SuperHero>)

     @Update
     suspend fun updateFav(hero: SuperHero)


    // seleccionar por Id
    @Query("SELECT* FROM task_table WHERE id=:id")
    fun getHeroById(id: Int):LiveData<SuperHero>

    //Traer todos los elementos
    @Query("SELECT * FROM task_table")
    fun getAllHero(): LiveData<List<SuperHero>>

}