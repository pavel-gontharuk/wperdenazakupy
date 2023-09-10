package com.gontharuk.wperdenazakupy.presentation

import android.app.Application
import com.gontharuk.wperdenazakupy.di.layers.AppComponent
import com.gontharuk.wperdenazakupy.di.layers.AppModule
import com.gontharuk.wperdenazakupy.di.layers.ComponentProvider
import com.gontharuk.wperdenazakupy.di.layers.DaggerAppComponent
import com.gontharuk.wperdenazakupy.di.layers.DaggerDataComponent
import com.gontharuk.wperdenazakupy.di.layers.DaggerDomainComponent
import com.gontharuk.wperdenazakupy.di.layers.DataComponent
import com.gontharuk.wperdenazakupy.di.layers.DomainComponent
import com.gontharuk.wperdenazakupy.sahredprefs.PrefProvider


class WperdeApplication : Application(), ComponentProvider {

    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    private val dataComponent: DataComponent by lazy {
        DaggerDataComponent.factory()
            .create(appComponent)
    }

    private val domainComponent: DomainComponent by lazy {
        DaggerDomainComponent.factory()
            .create(dataComponent)
    }

    override fun onCreate() {
        super.onCreate()
        PrefProvider.prepare(applicationContext)
    }

    override fun dataComponent(): DataComponent {
        return dataComponent
    }

    override fun domainComponent(): DomainComponent {
        return domainComponent
    }
}