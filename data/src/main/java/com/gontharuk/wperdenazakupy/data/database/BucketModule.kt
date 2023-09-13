package com.gontharuk.wperdenazakupy.data.database

import com.gontharuk.wperdenazakupy.data.database.bucket.BucketRepositoryImpl
import com.gontharuk.wperdenazakupy.domain.repository.BucketRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface BucketModule {

    @Binds
    @Singleton
    fun provideBucketRepository(
        bucketRepository: BucketRepositoryImpl
    ): BucketRepository
}