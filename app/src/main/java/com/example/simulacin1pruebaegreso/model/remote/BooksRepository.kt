package com.example.simulacin1pruebaegreso.model.remote

import android.util.Log
import com.example.simulacin1pruebaegreso.model.local.BooksDao
import com.example.simulacin1pruebaegreso.model.pojo.Books

class BooksRepository(private val dao: BooksDao) {
    val liveDataDB = dao.getAllBooksBD()


    suspend fun getRickMortyWithCourutines() {
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
}