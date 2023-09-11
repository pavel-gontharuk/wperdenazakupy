package com.gontharuk.wperdenazakupy.presentation.features.productlist.di

import com.gontharuk.wperdenazakupy.presentation.core.viewmodel.StateHolder
import com.gontharuk.wperdenazakupy.presentation.features.editproduct.EditProductState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ProductListModule {

    @Provides
    fun provideEditProductStateHolder(): StateHolder<EditProductState> =
        StateHolder(EditProductState())
}