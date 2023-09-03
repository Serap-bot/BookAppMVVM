package com.serapbekar.bookappmvvm.data.model

import com.google.gson.annotations.SerializedName

data class BookDetail(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("author") val author: String?,
    @SerializedName("publisher") val publisher: String?,
    @SerializedName("price") val price: Double?,
    @SerializedName("image_url") val imageUrl: String?,
    @SerializedName("best_seller") val BestSeller: Boolean?,
)