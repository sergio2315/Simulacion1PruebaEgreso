package com.example.simulacin1pruebaegreso.model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        private const val URI_BASE = "https://my-json-server.typicode.com/Himuravidal/anchorBooks/"

        fun retrofitInstance(): BooksApi {
            val retrofit = Retrofit.Builder().baseUrl(URI_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(BooksApi::class.java)
        }
    }
}