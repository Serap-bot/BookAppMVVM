package com.serapbekar.bookappmvvm.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.serapbekar.bookappmvvm.data.model.Books
import com.serapbekar.bookappmvvm.data.model.GetBookDetailResponse
import com.serapbekar.bookappmvvm.data.model.GetBooksResponse
import com.serapbekar.bookappmvvm.data.source.remote.BookService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksRepository(private val bookService: BookService) {

    val booksLiveData = MutableLiveData<List<Books>?>()
    val errorMessageLiveData = MutableLiveData<String>()
    val bookDetailLiveData = MutableLiveData<Books?>()
    val loadingLiveData = MutableLiveData<Boolean>()

    fun getBooks(){
        loadingLiveData.value = true
        bookService.getBooks().enqueue(object: Callback<GetBooksResponse> {
            override fun onResponse(call: Call<GetBooksResponse>, response: Response<GetBooksResponse>) {
                val result = response.body()?.books

                if(result.isNullOrEmpty().not()){
                    booksLiveData.value = result as List<Books>?
                } else {
                    booksLiveData.value = null
                }
                loadingLiveData.value = false
            }

            //Sunucuyla bağlantı hatalarında çalışır.
            override fun onFailure(call: Call<GetBooksResponse>, t: Throwable) {
                errorMessageLiveData.value = t.message.orEmpty()
                Log.e("GetBooks", t.message.orEmpty())
            }
        })
    }

    fun getBookDetail(id : Int){
        loadingLiveData.value = true
        bookService.getBookDetail(id).enqueue(object: Callback<GetBookDetailResponse> {
            override fun onResponse(
                call: Call<GetBookDetailResponse>,
                response: Response<GetBookDetailResponse>
            ) {

                bookDetailLiveData.value = response.body()?.book
                loadingLiveData.value = false
            }

            //Sunucuyla bağlantı hatalarında çalışır.
            override fun onFailure(call: Call<GetBookDetailResponse>, t: Throwable) {
                errorMessageLiveData.value = t.message.orEmpty()
                loadingLiveData.value = false
                Log.e("GetBooks", t.message.orEmpty())
            }
        })
    }

}