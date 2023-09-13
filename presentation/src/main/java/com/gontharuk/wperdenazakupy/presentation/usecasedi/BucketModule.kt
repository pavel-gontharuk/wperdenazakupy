package com.gontharuk.wperdenazakupy.presentation.usecasedi

import com.gontharuk.wperdenazakupy.domain.usecase.bucket.BucketUseCase
import com.gontharuk.wperdenazakupy.domain.usecase.bucket.BucketUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface BucketModule {

    @Binds
    fun provideBucketUseCase(
        bucketUseCase: BucketUseCaseImpl
    ): BucketUseCase
}