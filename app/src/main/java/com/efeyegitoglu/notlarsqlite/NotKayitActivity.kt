package com.efeyegitoglu.notlarsqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_not_kayit.*

class NotKayitActivity : AppCompatActivity() {

    private lateinit var vt: Veritabani

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_not_kayit)

        toolbarNotKayit.title = "Not Kayıt"
        setSupportActionBar(toolbarNotKayit)

        vt = Veritabani(this)



        buttonKaydet.setOnClickListener {

            val dersAdi = editTextDers.text.toString().trim()
            val not1 = editTextNot1.text.toString().trim()
            val not2 = editTextNot2.text.toString().trim()

            if (TextUtils.isEmpty(dersAdi)) {
                Snackbar.make(toolbarNotKayit, "Ders Adı Giriniz", Snackbar.LENGTH_SHORT)
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(not1)) {
                Snackbar.make(toolbarNotKayit, "İlk Notu Giriniz", Snackbar.LENGTH_SHORT)
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(not2)) {
                Snackbar.make(toolbarNotKayit, "İkinci Notu Giriniz", Snackbar.LENGTH_SHORT)
                return@setOnClickListener
            }

            Notlardao().notEkle(vt,dersAdi,not1.toInt(),not2.toInt())

            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
