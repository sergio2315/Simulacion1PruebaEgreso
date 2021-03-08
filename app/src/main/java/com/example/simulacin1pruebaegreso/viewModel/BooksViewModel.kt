package com.example.simulacin1pruebaegreso.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.simulacin1pruebaegreso.model.local.BooksDataBase
import com.example.simulacin1pruebaegreso.model.pojo.Books
import com.example.simulacin1pruebaegreso.model.pojo.DetailBooks
import com.example.simulacin1pruebaegreso.model.remote.BooksRepository
import kotlinx.coroutines.launch

class BooksViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: BooksRepository

    init {
        val dao = BooksDataBase.getDataBase(application).getBooksDao()
        repository = BooksRepository(dao)
        viewModelScope.launch {
            repository.getBooksWithCourutines()
            repository.getDetailBooksWithCourutines()
        }
    }
    fun getBooksList(): LiveData<List<Books>> = repository.liveDataDB

    private val selectedBook: MutableLiveData<Books> = MutableLiveData()
    fun selected(books: Books?) {
        selectedBook.value = books
    }


    fun getDetailBooksByID(id: Int): LiveData<DetailBooks> {
        return repository.getDetailBooksByID(id)
    }
    fun selectedItem(): LiveData<Books> = selectedBook

}