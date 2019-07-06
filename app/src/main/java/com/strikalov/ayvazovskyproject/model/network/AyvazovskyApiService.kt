package com.strikalov.ayvazovskyproject.model.network

import com.strikalov.ayvazovskyproject.model.entity.PictureList
import io.reactivex.Observable
import retrofit2.http.GET

interface AyvazovskyApiService {

    @GET("get_pictures")
    fun downloadPictureList(): Observable<PictureList>

}