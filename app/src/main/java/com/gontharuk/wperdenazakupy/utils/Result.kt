package com.gontharuk.wperdenazakupy.utils

fun <T> T.asSuccess(): Result<T> = Result.success<T>(this)