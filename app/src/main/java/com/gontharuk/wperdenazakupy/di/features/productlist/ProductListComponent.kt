package com.gontharuk.wperdenazakupy.di.features.productlist

import com.gontharuk.wperdenazakupy.di.layers.scopes.FeatureScope
import com.gontharuk.wperdenazakupy.di.layers.DomainComponent
import com.gontharuk.wperdenazakupy.presentation.features.productlist.ProductListViewModel
import dagger.Component

@Component(
    dependencies = [DomainComponent::class],
    modules = [ProductListModule::class]
)
@FeatureScope
interface ProductListComponent {

    fun getProductListViewModel(): ProductListViewModel

    @Component.Factory
    interface Factory {

        fun create(domainComponent: DomainComponent): ProductListComponent
    }
}