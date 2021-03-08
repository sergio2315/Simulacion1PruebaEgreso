package com.example.simulacin1pruebaegreso.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.simulacin1pruebaegreso.model.pojo.Books
import com.example.simulacin1pruebaegreso.model.pojo.DetailBooks

@Database(entities = [Books::class, DetailBooks::class],version = 1)
abstract class BooksDataBase: RoomDatabase() {
    abstract fun getBooksDao(): BooksDao
    companion object {
        @Volatile
        private var INSTANCE: BooksDataBase? = null

        fun getDataBase(context: Context): BooksDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BooksDataBase::class.java, "BooksDB"
                )
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}