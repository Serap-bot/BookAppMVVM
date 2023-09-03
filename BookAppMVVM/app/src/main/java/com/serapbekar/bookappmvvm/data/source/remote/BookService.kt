package com.serapbekar.bookappmvvm.data.source.remote

import com.serapbekar.bookappmvvm.common.Contants.Endpoint.GET_BOOKS
import com.serapbekar.bookappmvvm.common.Contants.Endpoint.GET_BOOK_DETAIL
import com.serapbekar.bookappmvvm.data.model.GetBookDetailResponse
import com.serapbekar.bookappmvvm.data.model.GetBooksResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {

    @GET(GET_BOOKS)
    fun getBooks(): Call<GetBooksResponse>

    @GET(GET_BOOK_DETAIL)
    fun getBookDetail(@Query("id") id:Int): Call<GetBookDetailResponse>

}