package com.gontharuk.wperdenazakupy.di.screens.productlist

import com.gontharuk.wperdenazakupy.di.ScreenScope
import com.gontharuk.wperdenazakupy.domain.usecase.productusecase.ProductUseCase
import com.gontharuk.wperdenazakupy.presentation.features.productlist.ProductListViewModel
import dagger.Module
import dagger.Provides

//@Module
//class ProductListModule {
//
//    @Provides
//    @ScreenScope
//    fun provideViewModel(
//        productUseCase: ProductUseCase
//    ): ProductListViewModel = ProductListViewModel(productUseCase)
//}