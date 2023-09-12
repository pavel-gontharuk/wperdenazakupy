package com.gontharuk.wperdenazakupy.data.database

import com.gontharuk.wperdenazakupy.data.database.product.ProductRepositoryImpl
import com.gontharuk.wperdenazakupy.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ProductModule {

    @Binds
    @Singleton
    fun provideProductRepository(
        productRepository: ProductRepositoryImpl
    ): ProductRepository
}