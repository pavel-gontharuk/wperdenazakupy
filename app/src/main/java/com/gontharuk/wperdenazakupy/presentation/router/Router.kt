package com.gontharuk.wperdenazakupy.presentation.router

import androidx.navigation.NavHostController

fun NavHostController.navigateTarget(target: NavTarget) {
    this.navigate(target.tag)
}