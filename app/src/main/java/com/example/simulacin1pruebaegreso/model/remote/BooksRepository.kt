package com.example.simulacin1pruebaegreso.model.remote

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.simulacin1pruebaegreso.model.local.BooksDao
import com.example.simulacin1pruebaegreso.model.pojo.Books
import com.example.simulacin1pruebaegreso.model.pojo.DetailBooks

class BooksRepository(private val dao: BooksDao) {
    val liveDataDB = dao.getAllBooksBD()

    suspend fun getBooksWithCourutines() {
        Log.d("REPOSITORY", "Utilizando corrutinas")
        try {
            val response = RetrofitClient.retrofitInstance().fetchBooksCoroutines()
            when (response.isSuccessful) {
                true -> response.body()?.let {
                    //aca se inserta en la base de datos
                    dao.insertAllBooks(it)
                }
                false -> Log.d("ERROR", "${response.code()}: ${response.errorBody()} ")
            }
        } catch (t: Throwable) {
            Log.e("ERROR CORRUTINA", t.message.toString())
        }
    }
    suspend fun getDetailBooksWithCourutines() {
        Log.d("REPOSITORY", "Utilizando corrutinas")
        try {
            val response = RetrofitClient.retrofitInstance().fetchDetailBooksCoroutines()
            when (response.isSuccessful) {
                true -> response.body()?.let {
                    //aca se inserta en la base de datos
                    dao.insertAllDetailBooks(it)
                }
                false -> Log.d("ERROR", "${response.code()}: ${response.errorBody()} ")
            }
        } catch (t: Throwable) {
            Log.e("ERROR CORRUTINA", t.message.toString())
        }
    }
    fun getDetailBooksByID(id: Int) : LiveData<DetailBooks> {
        return dao.getDetailBooksByID(id)
    }
}