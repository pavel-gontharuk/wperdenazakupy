package com.gontharuk.wperdenazakupy.sahredprefs

import android.content.Context
import android.content.SharedPreferences

object PrefProvider {

    enum class Store {
        PRODUCT,
        CATEGORY,
    }

    //TODO refactor to DataStore
    private val prefs: MutableMap<String, SharedPreferences> = mutableMapOf()

    fun prepare(context: Context) {
        Store.values().forEach {
            prefs[it.name] = context.getSharedPreferences(it.name, Context.MODE_PRIVATE)
        }
    }

    fun get(key: Store): SharedPreferences = prefs[key.name]!!
}