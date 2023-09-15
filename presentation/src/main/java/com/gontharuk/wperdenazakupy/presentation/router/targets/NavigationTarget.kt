package com.gontharuk.wperdenazakupy.presentation.router.targets

sealed class NavigationTarget(
    val tag: String,
    vararg keys: Any,
)