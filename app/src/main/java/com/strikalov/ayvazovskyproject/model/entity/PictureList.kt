package com.strikalov.ayvazovskyproject.model.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PictureList(

    @Expose
    @SerializedName("picture_list")
    val pictureList: List<Picture>

)