package com.strikalov.ayvazovskyproject.model.repositories

import com.strikalov.ayvazovskyproject.model.entity.Picture
import com.strikalov.ayvazovskyproject.model.network.AyvazovskyApi
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class NetworkRepositoryImpl(val ayvazovskyApi: AyvazovskyApi) : NetworkRepository{


    override fun downloadPictureList(): Observable<List<Picture>> {
        return ayvazovskyApi.downloadPictureList()
            .map {
                val pictures: MutableList<Picture> = ArrayList()

                it?.let {
                    pictureListApi ->
                    for ( picture in pictureListApi.pictureList ){
                        pictures.add(picture)
                    }
                }

                return@map pictures.toList()
            }
            .subscribeOn(Schedulers.io())
    }
}