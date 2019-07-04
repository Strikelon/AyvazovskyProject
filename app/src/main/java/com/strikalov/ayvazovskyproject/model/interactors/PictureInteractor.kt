package com.strikalov.ayvazovskyproject.model.interactors

import com.strikalov.ayvazovskyproject.model.entity.Picture
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable

interface PictureInteractor {

    fun downloadPictureListFromServer(): Observable<List<Picture>>

    fun savePictureListInDb(pictureList: List<Picture>): Completable

    fun getPictureByIdFromDb(id: Long): Maybe<Picture>

}