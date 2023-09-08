package com.gontharuk.wperdenazakupy.presentation.main.router

import androidx.navigation.NavHostController

fun NavHostController.navigateTarget(target: NavTarget) {
    this.navigate(target.tag)
}