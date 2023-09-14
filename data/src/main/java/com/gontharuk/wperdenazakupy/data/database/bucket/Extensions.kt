package com.gontharuk.wperdenazakupy.data.database.bucket

import com.gontharuk.wperdenazakupy.domain.model.Bucket

fun Bucket.toEntity(): BucketEntity = BucketEntity(
    id = id,
    name = name,
    productIds = productIds
)

fun BucketEntity.toModel(): Bucket = Bucket(
    id = id,
    name = name,
    productIds = productIds
)