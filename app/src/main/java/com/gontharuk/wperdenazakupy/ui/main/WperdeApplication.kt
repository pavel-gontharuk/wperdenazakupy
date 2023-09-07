package com.gontharuk.wperdenazakupy.ui.main

import android.app.Application
import androidx.room.Room
import com.gontharuk.wperdenazakupy.data.database.WperdeDatabase
import com.gontharuk.wperdenazakupy.sahredprefs.PrefProvider


class WperdeApplication : Application() {

    companion object {
        private lateinit var _database: WperdeDatabase
        val database: WperdeDatabase get() = _database
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