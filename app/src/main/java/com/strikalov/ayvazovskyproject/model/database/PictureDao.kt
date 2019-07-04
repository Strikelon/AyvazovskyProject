package com.strikalov.ayvazovskyproject.model.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Maybe

@Dao
interface PictureDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPictureList(pictureList: List<PictureRoomEntity>): Array<Long>

    @Query("SELECT * FROM picture_table WHERE id = :picId")
    fun getPictureById(picId: Long): Maybe<PictureRoomEntity>

}