package com.gontharuk.wperdenazakupy.presentation.features.editbucket

import com.gontharuk.wperdenazakupy.domain.model.Bucket
import com.gontharuk.wperdenazakupy.domain.model.Product

sealed class EditBucketState(val items: List<EditBucketItem> = emptyList()) {

    object Loading : EditBucketState()

    data class EditBucket(
        val bucket: Bucket,
        val products: List<Product>
    ) : EditBucketState(
        products.map {
            EditBucketItem(
                id = it.id,
                name = it.name,
                selected = bucket.productIds.contains(it.id),
            )
        }
    ) {
        fun clicked(item: EditBucketItem): EditBucketState {
            val update = bucket.productIds
                .toMutableSet()
                .also {
                    if (item.selected) it.remove(item.id)
                    else it.add(item.id)
                }.toSet()
            return this.copy(
                bucket = bucket.copy(productIds = update)
            )
        }
    }
}