package com.example.simulacin1pruebaegreso.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.simulacin1pruebaegreso.model.pojo.Books
import com.example.simulacin1pruebaegreso.model.pojo.DetailBooks

@Dao
interface BooksDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllBooks(list: List<Books>)

    @Query("SELECT * FROM books_table")
    fun getAllBooksBD(): LiveData<List<Books>>

    @Query("SELECT * FROM detailBooks_table WHERE id = :id")
    fun getDetailBooksByID(id: Int): LiveData<DetailBooks>
}