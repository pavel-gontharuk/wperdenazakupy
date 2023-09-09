package com.gontharuk.wperdenazakupy.di.product

import com.gontharuk.wperdenazakupy.domain.usecase.ProductUseCase
import com.gontharuk.wperdenazakupy.presentation.features.editproduct.EditProductViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun provideEditProductViewModel(
        productUseCase: ProductUseCase
    ): EditProductViewModel = EditProductViewModel(productUseCase)
}