package com.gontharuk.wperdenazakupy.presentation.features.editpurchaselist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gontharuk.wperdenazakupy.domain.model.Bucket
import com.gontharuk.wperdenazakupy.domain.usecase.bucket.BucketUseCase
import com.gontharuk.wperdenazakupy.domain.usecase.product.ProductUseCase
import com.gontharuk.wperdenazakupy.presentation.core.data.generateId
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

    private val _state: MutableStateFlow<EditBucketState> = MutableStateFlow(EditBucketState())
    val state: StateFlow<EditBucketState> = _state

    // TODO temporary key
    private val key = "TEMPORARY"

    private var bucket = Bucket(name = key)

    suspend fun fetch() {

        val purchases: ArrayList<Int> = ArrayList()
        val productsJob = viewModelScope.async(Dispatchers.IO) {
            productUseCase.products()
        }
        val bucketJob = viewModelScope.async(Dispatchers.IO) {
            bucketUseCase.getAll()
        }

        bucketJob.await().let {
            if (it.isNotEmpty()) it.first()
            else bucket
        }.also {
            bucket = it
            purchases.addAll(it.list)
        }

        productsJob.await().map {
            EditBucketItem(
                id = it.id,
                name = it.name,
                selected = purchases.contains(it.id)
            )
        }.also {
            _state.value = state.value.copy(list = it)
        }
    }

    fun clicked(item: EditBucketItem) {
        _state.value = state.value.let { current ->
            val list = current.list
                .toMutableList()
                .also {
                    it[it.indexOf(item)] = item.copy(selected = !item.selected)
                }
            current.copy(list = list)
        }
    }

    fun save() {
        viewModelScope.launch {
            bucket.copy(
                id = if (bucket.id <= 0) generateId(bucket.name)
                else bucket.id,
                list = state.value.list
                    .filter { it.selected }
                    .map { it.id }
            ).also {
                withContext(Dispatchers.IO) {
                    bucketUseCase.put(it)
                }
            }
        }
    }
}