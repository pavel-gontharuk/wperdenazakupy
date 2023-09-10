package com.gontharuk.wperdenazakupy.di.layers

import android.content.Context
import com.gontharuk.wperdenazakupy.di.layers.scopes.AppScope
import dagger.Component

@Component(modules = [AppModule::class])
@AppScope
interface AppComponent {

    fun getApplicationContext(): Context
}