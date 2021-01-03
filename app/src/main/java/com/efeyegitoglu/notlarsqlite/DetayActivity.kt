package com.efeyegitoglu.notlarsqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_detay.*
import kotlinx.android.synthetic.main.activity_not_kayit.*

class DetayActivity : AppCompatActivity() {

    private lateinit var not:Notlar
    private lateinit var vt:Veritabani

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        toolbarNotDetay.title = "Not Detayları"
        setSupportActionBar(toolbarNotDetay)

        vt=Veritabani(this)

        not=intent.getSerializableExtra("nesne") as Notlar
        editTextDersDetay.setText(not.ders_adi)
        editTextNot1Detay.setText((not.not1).toString())
        editTextNot2Detay.setText((not.not2).toString())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_sil -> {
                Snackbar.make(toolbarNotDetay,"Silinsin mi?",Snackbar.LENGTH_LONG)
                    .setAction("Evet"){

                        Notlardao().notSil(vt,not.not_id)

                        val intent= Intent(applicationContext,MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }.show()

                return true
            }
            R.id.action_duzenle -> {

                val dersAdi = editTextDersDetay.text.toString().trim()
                val not1 = editTextNot1Detay.text.toString().trim()
                val not2 = editTextNot2Detay.text.toString().trim()

                if (TextUtils.isEmpty(dersAdi)) {
                    Snackbar.make(toolbarNotDetay, "Ders Adı Giriniz", Snackbar.LENGTH_SHORT)
                    return false
                }
                if (TextUtils.isEmpty(not1)) {
                    Snackbar.make(toolbarNotDetay, "İlk Notu Giriniz", Snackbar.LENGTH_SHORT)
                    return false
                }
                if (TextUtils.isEmpty(not2)) {
                    Snackbar.make(toolbarNotDetay, "İkinci Notu Giriniz", Snackbar.LENGTH_SHORT)
                    return false
                }

                Notlardao().notGuncelle(vt,not.not_id,dersAdi,not1.toInt(),not2.toInt())

                val intent= Intent(applicationContext,MainActivity::class.java)
                startActivity(intent)
                finish()
                return true
            }
            else -> return false
        }

    }
}
