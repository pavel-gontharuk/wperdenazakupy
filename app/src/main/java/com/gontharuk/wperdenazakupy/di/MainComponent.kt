package com.gontharuk.wperdenazakupy.di

import com.gontharuk.wperdenazakupy.di.layers.DataComponent
import com.gontharuk.wperdenazakupy.presentation.features.editproduct.EditProductViewModel
import com.gontharuk.wperdenazakupy.presentation.features.productlist.ProductListViewModel
import dagger.Component

@Component(
    dependencies = [DataComponent::class],
    modules = [MainModule::class],
)
@ScreenScope
interface MainComponent {

    fun getProductListViewModel(): ProductListViewModel

    fun getEditProductViewModel(): EditProductViewModel

    @Component.Factory
    interface Factory {
        fun create(dataComponent: DataComponent): MainComponent
    }
}