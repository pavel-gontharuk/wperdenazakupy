package com.gontharuk.wperdenazakupy.di.product

import com.gontharuk.wperdenazakupy.data.database.WperdeDatabase
import com.gontharuk.wperdenazakupy.data.database.product.ProductRepositoryImpl
import com.gontharuk.wperdenazakupy.domain.repository.ProductRepository
import com.gontharuk.wperdenazakupy.domain.usecase.ProductUseCase
import com.gontharuk.wperdenazakupy.domain.usecase.ProductUseCaseImpl
import com.gontharuk.wperdenazakupy.presentation.WperdeApplication
import dagger.Module
import dagger.Provides

@Module
class ProductModule {

    // TODO move
    private val database: WperdeDatabase get() = WperdeApplication.database

    @Provides
    fun provideProductRepository(): ProductRepository = ProductRepositoryImpl(database.productDao())

    @Provides
    fun provideProductUseCase(
        productRepository: ProductRepository
    ): ProductUseCase = ProductUseCaseImpl(productRepository)
}