package com.gontharuk.wperdenazakupy.di.layers

import com.gontharuk.wperdenazakupy.data.database.WperdeDatabase
import com.gontharuk.wperdenazakupy.data.database.product.ProductRepositoryImpl
import com.gontharuk.wperdenazakupy.domain.repository.ProductRepository
import com.gontharuk.wperdenazakupy.presentation.WperdeApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    // TODO move
    private val database: WperdeDatabase get() = WperdeApplication.database

    @Singleton
    @Provides
    fun provideProductRepository(): ProductRepository = ProductRepositoryImpl(database.productDao())
}