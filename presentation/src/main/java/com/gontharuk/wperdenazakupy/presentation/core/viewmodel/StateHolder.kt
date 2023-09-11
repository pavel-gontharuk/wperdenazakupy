package com.gontharuk.wperdenazakupy.presentation.core.viewmodel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class StateHolder<T>(state: T) {

    private val _state: MutableStateFlow<T> = MutableStateFlow(state)
    val state: StateFlow<T> get() = _state

    fun updateState(update: (T) -> T) {
        _state.value = update(state.value)
    }
}