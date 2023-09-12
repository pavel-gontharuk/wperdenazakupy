package com.gontharuk.wperdenazakupy.presentation.usecasedi

import com.gontharuk.wperdenazakupy.domain.usecase.purchaselist.PurchaseListUseCase
import com.gontharuk.wperdenazakupy.domain.usecase.purchaselist.PurchaseListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface PurchaseListModule {

    @Binds
    fun providePurchaseListUseCase(
        purchaseListUseCase: PurchaseListUseCaseImpl
    ): PurchaseListUseCase
}