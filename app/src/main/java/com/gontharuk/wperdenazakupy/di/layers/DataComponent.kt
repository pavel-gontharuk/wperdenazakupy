package com.gontharuk.wperdenazakupy.di.layers

import com.gontharuk.wperdenazakupy.domain.repository.ProductRepository
import dagger.Component
import javax.inject.Singleton

@Component(modules = [DataModule::class])
@Singleton
interface DataComponent {

    fun getProductRepository(): ProductRepository
}