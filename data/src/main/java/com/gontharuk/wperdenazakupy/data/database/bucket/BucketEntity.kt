package com.gontharuk.wperdenazakupy.data.database.bucket

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bucket")
data class BucketEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val list: List<Int>
)
