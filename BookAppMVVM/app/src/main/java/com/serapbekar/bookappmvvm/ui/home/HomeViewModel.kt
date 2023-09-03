package com.serapbekar.bookappmvvm.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.serapbekar.bookappmvvm.data.model.Books
import com.serapbekar.bookappmvvm.data.repository.BooksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private  val booksRepository: BooksRepository) : ViewModel() {

    private var _booksLiveData = MutableLiveData<List<Books>?>()
    val booksLiveData : LiveData<List<Books>?>
        get() = _booksLiveData

    private var _errorMessageLiveData = MutableLiveData<String>()
    val errorMessageLiveData : LiveData<String>
        get() = _errorMessageLiveData

    private var _loadingLiveData = MutableLiveData<Boolean>()
    val loadingLiveData : LiveData<Boolean>
        get() = _loadingLiveData

    init {
        _booksLiveData = booksRepository.booksLiveData
        _errorMessageLiveData = booksRepository.errorMessageLiveData
        _loadingLiveData = booksRepository.loadingLiveData
    }

    fun getBooks(){
        booksRepository.getBooks()
    }
}