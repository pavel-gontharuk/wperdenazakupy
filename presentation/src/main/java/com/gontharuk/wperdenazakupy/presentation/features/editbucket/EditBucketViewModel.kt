package com.gontharuk.wperdenazakupy.presentation.features.editbucket

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gontharuk.wperdenazakupy.domain.model.Bucket
import com.gontharuk.wperdenazakupy.domain.usecase.bucket.BucketUseCase
import com.gontharuk.wperdenazakupy.domain.usecase.product.ProductUseCase
import com.gontharuk.wperdenazakupy.presentation.features.editbucket.entity.EditBucketItemModel
import com.gontharuk.wperdenazakupy.presentation.features.editbucket.entity.EditBucketState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class EditBucketViewModel @Inject constructor(
    private val bucketUseCase: BucketUseCase,
    private val productUseCase: ProductUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<EditBucketState> = MutableStateFlow(EditBucketState.Loading)
    val state: StateFlow<EditBucketState> = _state

    suspend fun fetch() {
        val products = viewModelScope.async(Dispatchers.IO) {
            productUseCase.products()
                .sortedBy { it.name }
        }
        val bucket = viewModelScope.async(Dispatchers.IO) {
            bucketUseCase.getAll()
        }
        _state.value = EditBucketState.EditBucket(
            bucket = bucket.await().firstOrNull() ?: Bucket(name = ""),
            products = products.await()
        )
    }

    fun clicked(item: EditBucketItemModel) {
        val state = (state.value as? EditBucketState.EditBucket) ?: return
        state.bucket.productIds
            .toMutableSet()
            .also {
                if (item.selected) it.remove(item.id)
                else it.add(item.id)
            }
            .toSet()
            .also { update ->
                _state.value = state.copy(
                    bucket = state.bucket.copy(productIds = update)
                )
            }
    }

    fun nameChanged(name: String) {
        val state = (state.value as? EditBucketState.EditBucket) ?: return
        if (state.bucket.name == name) return
        _state.value = state.copy(bucket = state.bucket.copy(name = name))
    }

    fun save() {
        val state = (state.value as? EditBucketState.EditBucket) ?: return
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                bucketUseCase.put(state.bucket)
            }
        }
    }
}