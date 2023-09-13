package com.gontharuk.wperdenazakupy.presentation.core.data

fun generateId(vararg keys: Any): Int {
    val builder = StringBuilder()
    keys.forEach { builder.append(it) }
    builder.append(System.currentTimeMillis())
    return builder.toString()
        .hashCode()
}