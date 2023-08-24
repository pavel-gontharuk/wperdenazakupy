package com.gontharuk.wperdenazakupy.ui.main

import android.app.Application
import com.gontharuk.wperdenazakupy.sahredprefs.PrefProvider


class WperdeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        PrefProvider.prepare(applicationContext)
    }
}