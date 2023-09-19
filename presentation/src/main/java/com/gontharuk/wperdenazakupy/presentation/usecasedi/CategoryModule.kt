package com.gontharuk.wperdenazakupy.presentation.usecasedi

import com.gontharuk.wperdenazakupy.domain.usecase.category.CategoryUseCase
import com.gontharuk.wperdenazakupy.domain.usecase.category.CategoryUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface CategoryModule {

    @Binds
    @Singleton
    fun provideCategoryUseCase(
        categoryUseCase: CategoryUseCaseImpl
    ): CategoryUseCase
}