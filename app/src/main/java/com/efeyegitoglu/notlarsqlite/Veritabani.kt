package com.efeyegitoglu.notlarsqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Veritabani(context: Context) : SQLiteOpenHelper(context, "notlar.sqlite", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("CREATE TABLE IF NOT EXISTS notlar(not_id INTEGER PRIMARY KEY AUTOINCREMENT,ders_adi TEXT,not1 INTEGER,not2 INTEGER);")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS notlar", null)
        onCreate(db)
    }
}