package com.gontharuk.wperdenazakupy.di.features.editproduct

import com.gontharuk.wperdenazakupy.di.layers.scopes.FeatureScope
import com.gontharuk.wperdenazakupy.domain.usecase.productusecase.ProductUseCase
import com.gontharuk.wperdenazakupy.presentation.features.productlist.ProductListViewModel
import dagger.Module
import dagger.Provides

@Module
class EditProductModule {

    @Provides
    @FeatureScope
    fun provideViewModel(
        productUseCase: ProductUseCase
    ): ProductListViewModel = ProductListViewModel(productUseCase)
}