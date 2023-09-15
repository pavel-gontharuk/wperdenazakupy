package com.gontharuk.wperdenazakupy.presentation.features.editbucket.entity

import com.gontharuk.wperdenazakupy.domain.model.Bucket
import com.gontharuk.wperdenazakupy.domain.model.Product

sealed class EditBucketState {

    object Loading : EditBucketState()

    data class EditBucket(
        val bucket: Bucket,
        val products: List<Product>
    ) : EditBucketState() {
        val items: List<EditBucketItemModel> by lazy {
            products.map {
                EditBucketItemModel(
                    id = it.id,
                    name = it.name,
                    selected = bucket.productIds.contains(it.id),
                )
            }
        }
    }
}