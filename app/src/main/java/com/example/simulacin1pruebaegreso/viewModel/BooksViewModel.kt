package com.example.simulacin1pruebaegreso.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.simulacin1pruebaegreso.model.local.BooksDataBase
import com.example.simulacin1pruebaegreso.model.pojo.Books
import com.example.simulacin1pruebaegreso.model.remote.BooksRepository
import kotlinx.coroutines.launch

class BooksViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: BooksRepository

    init {
        val dao = BooksDataBase.getDataBase(application).getBooksDao()
        repository = BooksRepository(dao)
        viewModelScope.launch {
            repository.getRickMortyWithCourutines()
        }
    }
    fun getBooksList(): LiveData<List<Books>> = repository.liveDataDB
}