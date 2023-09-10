package com.gontharuk.wperdenazakupy.di.layers

import com.gontharuk.wperdenazakupy.di.layers.scopes.DomainScope
import com.gontharuk.wperdenazakupy.domain.repository.ProductRepository
import com.gontharuk.wperdenazakupy.domain.usecase.productusecase.ProductUseCase
import com.gontharuk.wperdenazakupy.domain.usecase.productusecase.ProductUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    @DomainScope
    fun provideProductUseCase(
        productRepository: ProductRepository
    ): ProductUseCase = ProductUseCaseImpl(productRepository)
}