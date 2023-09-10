package com.gontharuk.wperdenazakupy.di.product

import com.gontharuk.wperdenazakupy.data.database.product.ProductDao
import com.gontharuk.wperdenazakupy.data.database.product.ProductRepositoryImpl
import com.gontharuk.wperdenazakupy.domain.repository.ProductRepository
import com.gontharuk.wperdenazakupy.domain.usecase.productusecase.ProductUseCase
import com.gontharuk.wperdenazakupy.domain.usecase.productusecase.ProductUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ProductModule {

    @Provides
    fun provideProductRepository(
        dao: ProductDao
    ): ProductRepository = ProductRepositoryImpl(dao)

    @Provides
    fun provideProductUseCase(
        productRepository: ProductRepository
    ): ProductUseCase = ProductUseCaseImpl(productRepository)
}