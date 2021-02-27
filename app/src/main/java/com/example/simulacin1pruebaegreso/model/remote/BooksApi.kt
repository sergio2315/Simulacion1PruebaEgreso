package com.example.simulacin1pruebaegreso.model.remote

import com.example.simulacin1pruebaegreso.model.pojo.Books
import retrofit2.Response
import retrofit2.http.GET

interface BooksApi {
    @GET("books")
    suspend fun fetchBooksCoroutines(): Response<List<Books>>
}