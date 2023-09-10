package com.gontharuk.wperdenazakupy.di.features

import com.gontharuk.wperdenazakupy.di.features.editproduct.DaggerEditProductComponent
import com.gontharuk.wperdenazakupy.di.features.editproduct.EditProductComponent
import com.gontharuk.wperdenazakupy.di.features.productlist.DaggerProductListComponent
import com.gontharuk.wperdenazakupy.di.features.productlist.ProductListComponent
import com.gontharuk.wperdenazakupy.di.layers.ComponentProvider


inline fun <reified T> component(provider: ComponentProvider): T = when (T::class.java) {

    EditProductComponent::class.java -> DaggerEditProductComponent.factory()
        .create(provider.domainComponent()) as T

    ProductListComponent::class.java -> DaggerProductListComponent.factory()
        .create(provider.domainComponent()) as T

    else -> throw IllegalArgumentException("${T::class}} is not a component")
}
