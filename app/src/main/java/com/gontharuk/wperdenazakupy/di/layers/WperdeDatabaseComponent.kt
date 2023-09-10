package com.gontharuk.wperdenazakupy.di.layers

import com.gontharuk.wperdenazakupy.data.database.WperdeDatabase
import dagger.Component

@Component
interface WperdeDatabaseComponent {

    fun getWperdeDatabase(): WperdeDatabase
}