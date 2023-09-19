package com.gontharuk.wperdenazakupy.data.database

import com.gontharuk.wperdenazakupy.data.database.category.CategoryRepositoryImpl
import com.gontharuk.wperdenazakupy.domain.repository.CategoryRepository
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
    fun provideCategoryRepository(
        categoryRepositoryImpl: CategoryRepositoryImpl
    ): CategoryRepository
}