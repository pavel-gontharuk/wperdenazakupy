package com.gontharuk.wperdenazakupy.di.layers

interface ComponentProvider {

    @Deprecated("Perhaps redundant")
    fun dataComponent(): DataComponent

    fun domainComponent(): DomainComponent
}