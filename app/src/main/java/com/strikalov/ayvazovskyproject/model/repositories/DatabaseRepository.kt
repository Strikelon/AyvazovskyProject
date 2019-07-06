package com.strikalov.ayvazovskyproject.model.repositories

import com.strikalov.ayvazovskyproject.model.entity.Picture
import io.reactivex.Completable
import io.reactivex.Maybe

interface DatabaseRepository {

    fun savePictureList(pictureList: List<Picture>): Completable

    fun getPictureById(id: Long): Maybe<Picture>

}