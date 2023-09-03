package com.serapbekar.bookappmvvm.data.model


import com.google.gson.annotations.SerializedName

data class GetBooksResponse(
    @SerializedName("books") val books: List<Books?>?,
    @SerializedName("success") val success: Int?,
    @SerializedName("message") val message: String?
)