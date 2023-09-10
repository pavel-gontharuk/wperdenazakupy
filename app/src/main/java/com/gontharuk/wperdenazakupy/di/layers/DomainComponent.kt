package com.gontharuk.wperdenazakupy.di.layers

import com.gontharuk.wperdenazakupy.di.layers.scopes.DomainScope
import com.gontharuk.wperdenazakupy.domain.usecase.productusecase.ProductUseCase
import dagger.Component

@Component(
    dependencies = [DataComponent::class],
    modules = [DomainModule::class]
)
@DomainScope
interface DomainComponent {

    fun fetProductUseCase(): ProductUseCase

    @Component.Factory
    interface Factory {

        fun create(dataComponent: DataComponent): DomainComponent
    }
}