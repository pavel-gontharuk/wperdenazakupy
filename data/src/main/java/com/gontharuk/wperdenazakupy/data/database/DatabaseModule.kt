package com.gontharuk.wperdenazakupy.data.database

import android.content.Context
import androidx.room.Room
import com.gontharuk.wperdenazakupy.data.database.product.ProductDao
import com.gontharuk.wperdenazakupy.data.database.product.ProductRepositoryImpl
import com.gontharuk.wperdenazakupy.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideWperdeDatabase(
        @ApplicationContext context: Context
    ): WperdeDatabase = Room.databaseBuilder(
        context,
        WperdeDatabase::class.java,
        "wperde_database",
    ).build()

    @Provides
    fun provideProductDao(
        database: WperdeDatabase
    ): ProductDao = database.productDao()

    @Provides
    fun provideProductRepository(
        dao: ProductDao
    ): ProductRepository = ProductRepositoryImpl(dao)
}