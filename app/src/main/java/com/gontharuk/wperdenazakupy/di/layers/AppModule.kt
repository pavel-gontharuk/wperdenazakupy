package com.gontharuk.wperdenazakupy.di.layers

import android.app.Application
import android.content.Context
import com.gontharuk.wperdenazakupy.di.layers.scopes.AppScope
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val application: Application) {

    @Provides
    @AppScope
    fun provideApplicationContext(): Context = application.applicationContext
}