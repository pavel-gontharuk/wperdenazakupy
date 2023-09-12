package com.gontharuk.wperdenazakupy.presentation.features.editpurchaselist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gontharuk.wperdenazakupy.domain.model.PurchaseList
import com.gontharuk.wperdenazakupy.domain.usecase.product.ProductUseCase
import com.gontharuk.wperdenazakupy.domain.usecase.purchaselist.PurchaseListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditPurchaseListViewModel @Inject constructor(
    private val purchaseListUseCase: PurchaseListUseCase,
    private val productUseCase: ProductUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<EditPurchaseListState> = MutableStateFlow(EditPurchaseListState())
    val state: StateFlow<EditPurchaseListState> = _state

    private val purchases: ArrayList<String> = ArrayList()

    // TODO temporary key
    private val key = "PEPEGA"

    suspend fun fetch() {

        val productsJob = viewModelScope.async(Dispatchers.IO) {
            productUseCase.products()
        }

        val purchaseJob = viewModelScope.async(Dispatchers.IO) {
            purchaseListUseCase.getAllKey(key)
        }

        purchaseJob.await().let {
            if (it.isNotEmpty()) it.first()
            else PurchaseList(key)
        }.also {
            purchases.addAll(it.list)
        }

        productsJob.await().map {
            EditPurchaseListItem(
                name = it.name,
                selected = purchases.contains(it.name)
            )
        }.also {
            _state.value = state.value.copy(list = it)
        }
    }

    fun clicked(item: EditPurchaseListItem) {
        viewModelScope.launch {

        }
    }

    fun save() {
        viewModelScope.launch {

        }
    }
}