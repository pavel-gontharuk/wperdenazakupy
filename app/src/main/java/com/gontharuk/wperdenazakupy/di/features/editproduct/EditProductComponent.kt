package com.gontharuk.wperdenazakupy.di.features.editproduct

import com.gontharuk.wperdenazakupy.di.layers.scopes.FeatureScope
import com.gontharuk.wperdenazakupy.di.layers.DomainComponent
import com.gontharuk.wperdenazakupy.presentation.features.editproduct.EditProductViewModel
import dagger.Component

@Component(
    dependencies = [DomainComponent::class],
    modules = [EditProductModule::class]
)
@FeatureScope
interface EditProductComponent {

    fun getEditProductViewModel(): EditProductViewModel

    @Component.Factory
    interface Factory {

        fun create(domainComponent: DomainComponent): EditProductComponent
    }
}