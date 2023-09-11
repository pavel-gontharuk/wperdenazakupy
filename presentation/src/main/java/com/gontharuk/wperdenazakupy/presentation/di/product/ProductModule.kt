package com.gontharuk.wperdenazakupy.presentation.di.product

import com.gontharuk.wperdenazakupy.domain.usecase.productusecase.ProductUseCase
import com.gontharuk.wperdenazakupy.domain.usecase.productusecase.ProductUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ProductModule {

    @Binds
    fun provideProductUseCase(
        productUseCase: ProductUseCaseImpl
    ): ProductUseCase
}