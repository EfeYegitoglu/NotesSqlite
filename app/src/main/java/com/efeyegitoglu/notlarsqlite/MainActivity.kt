package com.efeyegitoglu.notlarsqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var notlarList:ArrayList<Notlar>
    private lateinit var adapter:NotlarAdapter
    private lateinit var vt:Veritabani

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title="Notlar Uygulaması"
        toolbar.subtitle="Ortalama: 0"
        setSupportActionBar(toolbar)

        rv.setHasFixedSize(true)
        rv.layoutManager=LinearLayoutManager(this)

        vt=Veritabani(this)

        notlarList= Notlardao().tumNotlar(vt)




        adapter=NotlarAdapter(this,notlarList)
        rv.adapter=adapter

        var toplam=0

        for (n in notlarList){
            toplam+=(n.not1+n.not2)/2
        }

        if (toplam!=0){
            toolbar.subtitle="Ortalama: ${toplam/notlarList.size}"
        }

        fab.setOnClickListener{

            val intent=Intent(applicationContext,NotKayitActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        val intent =Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}
