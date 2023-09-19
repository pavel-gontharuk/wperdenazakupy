package com.gontharuk.wperdenazakupy.presentation.usecasedi

import com.gontharuk.wperdenazakupy.domain.usecase.product.ProductUseCase
import com.gontharuk.wperdenazakupy.domain.usecase.product.ProductUseCaseImpl
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
    fun provideProductUseCase(
        productUseCase: ProductUseCaseImpl
    ): ProductUseCase
}