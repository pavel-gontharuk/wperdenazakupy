package com.gontharuk.wperdenazakupy.presentation.features.editproduct.di

import com.gontharuk.wperdenazakupy.presentation.core.viewmodel.StateHolder
import com.gontharuk.wperdenazakupy.presentation.features.productlist.ProductListState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object EditProductModule {

    @Provides
    fun provideProductListStateHolder(): StateHolder<ProductListState> =
        StateHolder(ProductListState())
}