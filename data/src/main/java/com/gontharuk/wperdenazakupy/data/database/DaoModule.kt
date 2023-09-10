package com.gontharuk.wperdenazakupy.data.database

import com.gontharuk.wperdenazakupy.data.database.product.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    fun provideProductDao(
        database: WperdeDatabase
    ): ProductDao = database.productDao()
}