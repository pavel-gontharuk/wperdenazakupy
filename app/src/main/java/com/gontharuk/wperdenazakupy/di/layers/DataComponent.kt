package com.gontharuk.wperdenazakupy.di.layers

import com.gontharuk.wperdenazakupy.data.database.WperdeDatabase
import com.gontharuk.wperdenazakupy.di.layers.scopes.DataScope
import com.gontharuk.wperdenazakupy.domain.repository.ProductRepository
import dagger.Component

@Component(
    dependencies = [AppComponent::class],
    modules = [DataModule::class]
)
@DataScope
interface DataComponent {

    fun getProductRepository(): ProductRepository

    fun getWperdeDatabase(): WperdeDatabase

    @Component.Factory
    interface Factory {

        fun create(appComponent: AppComponent): DataComponent
    }
}