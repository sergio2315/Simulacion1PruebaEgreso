package com.example.simulacin1pruebaegreso.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.simulacin1pruebaegreso.model.pojo.Books

@Dao
interface BooksDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllBooks(Bookslist: List<Books>)

    @Query("SELECT * FROM books_table")
    fun getAllBooksBD(): LiveData<List<Books>>
}