package com.strikalov.ayvazovskyproject.model.repositories

import com.strikalov.ayvazovskyproject.model.database.AppDatabase
import com.strikalov.ayvazovskyproject.model.database.PictureRoomEntity
import com.strikalov.ayvazovskyproject.model.entity.Picture
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.schedulers.Schedulers

class DatabaseRepositoryImpl(val appDatabase: AppDatabase): DatabaseRepository {

    private fun createPictureRoomEntity(pictureList: List<Picture>): List<PictureRoomEntity>{

        val listPictureRoomEntity: MutableList<PictureRoomEntity> = ArrayList()

        for(picture in pictureList){

            val pictureRoomEntity = PictureRoomEntity(
                picture.id.toLong(),
                picture.name,
                picture.url,
                picture.place,
                picture.year,
                picture.size
            )

            listPictureRoomEntity.add(pictureRoomEntity)
        }

        return listPictureRoomEntity

    }

    private fun createPicture(pictureRoomEntity: PictureRoomEntity): Picture{
        return Picture(
            pictureRoomEntity.id.toInt(),
            pictureRoomEntity.name,
            pictureRoomEntity.url,
            pictureRoomEntity.place,
            pictureRoomEntity.year,
            pictureRoomEntity.size
        )
    }

    override fun savePictureList(pictureList: List<Picture>): Completable {

        val listPictureRoomEntity = createPictureRoomEntity(pictureList)

        return Completable.fromCallable {
            appDatabase.pictureDao().insertPictureList(listPictureRoomEntity)
        }.subscribeOn(Schedulers.io())

    }

    override fun getPictureById(id: Long): Maybe<Picture> {

        return appDatabase.pictureDao().getPictureById(id)
            .map {
                return@map createPicture(it)
            }
            .subscribeOn(Schedulers.io())
    }

}