package com.example.super_hero.remote.pojo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.super_hero.remote.SuperHero
import com.example.super_hero.view_model.HeroDAO


@Database(entities = [SuperHero::class],version = 1)
abstract class HeroDataBase : RoomDatabase() {

    abstract fun heroDao(): HeroDAO

    companion object {
        @Volatile
        private var INSTANCE: HeroDataBase? = null

        fun getDataBase(context: Context): HeroDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HeroDataBase::class.java,
                    "hero_database"
                )
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}