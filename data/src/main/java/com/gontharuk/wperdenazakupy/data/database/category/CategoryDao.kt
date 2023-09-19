package com.gontharuk.wperdenazakupy.data.database.category

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gontharuk.wperdenazakupy.domain.model.Category

interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun put(vararg category: CategoryEntity)

    @Query("SELECT * FROM category")
    fun getAll(): List<CategoryEntity>

    @Query("SELECT * FROM category WHERE id LIKE :id")
    fun getById(id: Int): List<Category>
}