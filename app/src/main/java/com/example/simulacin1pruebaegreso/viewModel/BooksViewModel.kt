package com.example.simulacin1pruebaegreso.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.simulacin1pruebaegreso.model.local.BooksDataBase
import com.example.simulacin1pruebaegreso.model.pojo.Books
import com.example.simulacin1pruebaegreso.model.remote.BooksRepository
import kotlinx.coroutines.launch

class BooksViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: BooksRepository
    val booksLiveDataDB: LiveData<List<Books>>

    init {
        val dao = BooksDataBase.getDataBase(application).getBooksDao()
        repository = BooksRepository(dao)
        viewModelScope.launch {
            repository.getRickMortyWithCourutines()
        }
        booksLiveDataDB = repository.liveDataDB
    }
    //fun getBooksList(): LiveData<List<Books>> = repository.liveDataDB
}