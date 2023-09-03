package com.serapbekar.bookappmvvm.data.model

import com.google.gson.annotations.SerializedName

class GetBookDetailResponse (
    @SerializedName("book") val book: Books?,
    @SerializedName("success") val success: Int?,
    @SerializedName("message") val message: String?
)