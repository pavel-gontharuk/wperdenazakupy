package com.gontharuk.wperdenazakupy.di.layers

import android.content.Context
import androidx.room.Room
import com.gontharuk.wperdenazakupy.data.database.WperdeDatabase
import com.gontharuk.wperdenazakupy.data.database.product.ProductRepositoryImpl
import com.gontharuk.wperdenazakupy.di.layers.scopes.DataScope
import com.gontharuk.wperdenazakupy.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    /** DATABASE */

    @Provides
    @DataScope
    fun provideDatabase(
        applicationContext: Context
    ): WperdeDatabase = Room.databaseBuilder(
        applicationContext,
        WperdeDatabase::class.java,
        "wperde_database",
    ).build()

    /** ^ DATABASE ^ */

    /** REPOSITORIES */

    @Provides
    @DataScope
    fun provideProductRepository(
        database: WperdeDatabase
    ): ProductRepository = ProductRepositoryImpl(database.productDao())

    /** ^ REPOSITORIES ^ */
}