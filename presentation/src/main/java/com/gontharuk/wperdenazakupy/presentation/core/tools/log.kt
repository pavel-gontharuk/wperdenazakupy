package com.gontharuk.wperdenazakupy.presentation.core.tools

import android.util.Log

fun <T> T.log(): T = this.also {
    val field: String = if (it is String) it else it.toString()
    val stringBuilder = StringBuilder()
    val trace = if (field.isNotEmpty() && field.isNotBlank()) Throwable().stackTrace[1]
    else Throwable().stackTrace[2]
    stringBuilder.append(trace.className.split(".").last())
    stringBuilder.append(".${trace.methodName}")
    stringBuilder.append(":${trace.lineNumber}")
    if (field.isNotEmpty() && field.isNotBlank()) stringBuilder.append(" > $field")
    Log.d("logging", stringBuilder.toString())
}