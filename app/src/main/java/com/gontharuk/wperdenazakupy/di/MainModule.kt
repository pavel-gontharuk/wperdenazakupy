package com.gontharuk.wperdenazakupy.di

import com.gontharuk.wperdenazakupy.domain.repository.ProductRepository
import com.gontharuk.wperdenazakupy.domain.usecase.productusecase.ProductUseCase
import com.gontharuk.wperdenazakupy.domain.usecase.productusecase.ProductUseCaseImpl
import com.gontharuk.wperdenazakupy.presentation.features.productlist.ProductListViewModel
import dagger.Module
import dagger.Provides

@Module
object MainModule {

    @Provides
    @ScreenScope
    fun provideProductUseCase(
        productRepository: ProductRepository
    ): ProductUseCase = ProductUseCaseImpl(productRepository)

    @Provides
    @ScreenScope
    fun provideViewModel(
        productUseCase: ProductUseCase
    ): ProductListViewModel = ProductListViewModel(productUseCase)
}