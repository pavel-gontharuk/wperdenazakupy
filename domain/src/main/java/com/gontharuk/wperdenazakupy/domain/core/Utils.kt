package com.gontharuk.wperdenazakupy.domain.core

fun generateId(vararg key: Any): Int = StringBuilder().let { builder ->
    key.forEach { builder.append(it) }
    builder.toString()
        .hashCode()
}
