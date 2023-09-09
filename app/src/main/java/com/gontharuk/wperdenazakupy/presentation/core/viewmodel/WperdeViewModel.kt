package com.gontharuk.wperdenazakupy.presentation.core.viewmodel

import androidx.lifecycle.ViewModel
import com.gontharuk.wperdenazakupy.utils.log
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class WperdeViewModel<S>(state: S) : ViewModel() {

    private val _state: MutableStateFlow<S> = MutableStateFlow(state)
    val state: StateFlow<S> = _state

    protected fun updateState(update: (S) -> S) {
        _state.value = update(state())
    }

    protected fun state(): S = _state.value!!
}