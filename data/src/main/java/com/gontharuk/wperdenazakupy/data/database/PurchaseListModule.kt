package com.gontharuk.wperdenazakupy.data.database

import com.gontharuk.wperdenazakupy.data.database.purchaselist.PurchaseListRepositoryImpl
import com.gontharuk.wperdenazakupy.domain.repository.PurchaseListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface PurchaseListModule {

    @Binds
    @Singleton
    fun providePurchaseListRepository(
        purchaseListRepository: PurchaseListRepositoryImpl
    ): PurchaseListRepository
}