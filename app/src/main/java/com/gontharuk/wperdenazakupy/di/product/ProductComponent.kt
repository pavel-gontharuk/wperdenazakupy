package com.gontharuk.wperdenazakupy.di.product

import com.gontharuk.wperdenazakupy.presentation.features.editproduct.EditProductViewModel
import com.gontharuk.wperdenazakupy.presentation.features.productlist.ProductListViewModel
import dagger.Component

@Component(modules = [ProductModule::class])
interface ProductComponent {

    fun inject(viewModel: ProductListViewModel)

    fun inject(viewModel: EditProductViewModel)
}