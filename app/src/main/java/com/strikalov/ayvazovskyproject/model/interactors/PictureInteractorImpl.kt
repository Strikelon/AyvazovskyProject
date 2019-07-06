package com.strikalov.ayvazovskyproject.model.interactors

import com.strikalov.ayvazovskyproject.model.entity.Picture
import com.strikalov.ayvazovskyproject.model.repositories.DatabaseRepository
import com.strikalov.ayvazovskyproject.model.repositories.NetworkRepository
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable

class PictureInteractorImpl(val networkRepository: NetworkRepository, val databaseRepository: DatabaseRepository): PictureInteractor {

    override fun downloadPictureListFromServer(): Observable<List<Picture>> {
        return networkRepository.downloadPictureList()
    }

    override fun savePictureListInDb(pictureList: List<Picture>): Completable {
        return databaseRepository.savePictureList(pictureList)
    }

    override fun getPictureByIdFromDb(id: Long): Maybe<Picture> {
        return databaseRepository.getPictureById(id)
    }
}