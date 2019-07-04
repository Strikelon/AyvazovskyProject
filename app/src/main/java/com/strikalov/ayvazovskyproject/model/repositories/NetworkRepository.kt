package com.strikalov.ayvazovskyproject.model.repositories

import com.strikalov.ayvazovskyproject.model.entity.Picture
import io.reactivex.Observable

interface NetworkRepository {

    fun downloadPictureList(): Observable<List<Picture>>

}