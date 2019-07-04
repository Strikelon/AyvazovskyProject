package com.strikalov.ayvazovskyproject.model.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Picture(

    @Expose
    @SerializedName("id")
    val id: Int,

    @Expose
    @SerializedName("name")
    val name: String,

    @Expose
    @SerializedName("url")
    val url: String,

    @Expose
    @SerializedName("place")
    val place: String,

    @Expose
    @SerializedName("year")
    val year: String,

    @Expose
    @SerializedName("size")
    val size: String

)