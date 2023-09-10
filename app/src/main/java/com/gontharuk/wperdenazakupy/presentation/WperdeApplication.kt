package com.gontharuk.wperdenazakupy.presentation

import android.app.Application
import androidx.room.Room
import com.gontharuk.wperdenazakupy.data.database.WperdeDatabase
import com.gontharuk.wperdenazakupy.di.layers.DaggerDataComponent
import com.gontharuk.wperdenazakupy.di.layers.DataComponent
import com.gontharuk.wperdenazakupy.sahredprefs.PrefProvider


class WperdeApplication : Application() {

    companion object {
        private lateinit var _database: WperdeDatabase
        val database: WperdeDatabase get() = _database

        val dataComponent: DataComponent by lazy { DaggerDataComponent.create() }
    }

    override fun onCreate() {
        super.onCreate()
        PrefProvider.prepare(applicationContext)
        _database = Room.databaseBuilder(
            applicationContext,
            WperdeDatabase::class.java,
            "wperde_database",
        ).build()
    }
}