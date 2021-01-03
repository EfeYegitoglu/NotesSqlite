package com.efeyegitoglu.notlarsqlite

import android.content.ContentValues

class Notlardao {

    fun tumNotlar(vt: Veritabani): ArrayList<Notlar> {
        val db = vt.writableDatabase
        val notlarList = ArrayList<Notlar>()

        val cursor = db.rawQuery("SELECT * FROM notlar", null)

        while (cursor.moveToNext()) {
            val not = Notlar(
                cursor.getInt(cursor.getColumnIndex("not_id"))
                , cursor.getString(cursor.getColumnIndex("ders_adi"))
                , cursor.getInt(cursor.getColumnIndex("not1"))
                , cursor.getInt(cursor.getColumnIndex("not2"))
            )

            notlarList.add(not)
        }
        return notlarList
    }

    fun notSil(vt: Veritabani, not_id: Int) {
        val db = vt.writableDatabase
        db.delete("notlar", "not_id=?", arrayOf(not_id.toString()))
        db.close()
    }

    fun notEkle(vt: Veritabani, ders_adi: String, not1: Int, not2: Int) {
        val db = vt.writableDatabase

        val values = ContentValues()
        values.put("ders_adi", ders_adi)
        values.put("not1", not1)
        values.put("not2", not2)

        db.insertOrThrow("notlar", null, values)
        db.close()
    }

    fun notGuncelle(vt: Veritabani, not_id: Int, ders_adi: String, not1: Int, not2: Int) {
        val db = vt.writableDatabase

        val values = ContentValues()
        values.put("ders_adi", ders_adi)
        values.put("not1", not1)
        values.put("not2", not2)

        db.update("notlar", values, "not_id=?", arrayOf(not_id.toString()))
        db.close()
    }
}