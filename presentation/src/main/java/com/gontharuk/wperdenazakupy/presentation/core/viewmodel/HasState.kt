package com.gontharuk.wperdenazakupy.presentation.core.viewmodel

import kotlinx.coroutines.flow.StateFlow

interface HasState<T> {

    val state: StateFlow<T>
}