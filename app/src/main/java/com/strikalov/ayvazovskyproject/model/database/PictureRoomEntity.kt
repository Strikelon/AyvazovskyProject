package com.strikalov.ayvazovskyproject.model.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "picture_table")
class PictureRoomEntity(

    @PrimaryKey var id: Long,

    @ColumnInfo var name: String,

    @ColumnInfo var url: String,

    @ColumnInfo var place: String,

    @ColumnInfo var year: String,

    @ColumnInfo var size: String

    )