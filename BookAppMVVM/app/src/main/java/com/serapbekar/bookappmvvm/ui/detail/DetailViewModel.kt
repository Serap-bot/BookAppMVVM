package com.serapbekar.bookappmvvm.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.serapbekar.bookappmvvm.data.model.Books
import com.serapbekar.bookappmvvm.data.repository.BooksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private  val booksRepository: BooksRepository) : ViewModel() {

    private var _bookDetailLiveData = MutableLiveData<Books?>()
    val bookDetailLiveData : LiveData<Books?>
        get() = _bookDetailLiveData

    private var _errorMessageLiveData = MutableLiveData<String>()
    val errorMessageLiveData : LiveData<String>
        get() = _errorMessageLiveData

    private var _loadingLiveData = MutableLiveData<Boolean>()
    val loadingLiveData : LiveData<Boolean>
        get() = _loadingLiveData

    init {
        _bookDetailLiveData = booksRepository.bookDetailLiveData
        _errorMessageLiveData = booksRepository.errorMessageLiveData
        _loadingLiveData = booksRepository.loadingLiveData
    }

    fun getBookDetail(id : Int){
        booksRepository.getBookDetail(id)
    }

}