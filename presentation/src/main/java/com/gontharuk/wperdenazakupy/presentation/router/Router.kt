package com.gontharuk.wperdenazakupy.presentation.router

import androidx.navigation.NavHostController
import com.gontharuk.wperdenazakupy.presentation.router.targets.NavigationTarget

fun NavHostController.navigateTarget(target: NavigationTarget) {
    this.navigate(target.tag)
}