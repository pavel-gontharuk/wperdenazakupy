package com.gontharuk.wperdenazakupy.presentation.di.product

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
    fun provideProductUseCase(
        productRepository: ProductRepository
    ): ProductUseCase = ProductUseCaseImpl(productRepository)
}