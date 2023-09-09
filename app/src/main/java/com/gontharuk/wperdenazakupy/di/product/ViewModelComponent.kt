package com.gontharuk.wperdenazakupy.di.product

import dagger.Component

@Component(
    modules = [
        ViewModelModule::class,
        ProductModule::class
    ]
)
interface ViewModelComponent {
}