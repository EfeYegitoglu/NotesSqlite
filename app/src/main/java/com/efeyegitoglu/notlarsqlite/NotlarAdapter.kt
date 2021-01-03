package com.efeyegitoglu.notlarsqlite

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class NotlarAdapter(private val mContext: Context, private val notlarList: List<Notlar>) :
    RecyclerView.Adapter<NotlarAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(tasarim: View) : RecyclerView.ViewHolder(tasarim) {

        var notCard: CardView
        var textDers: TextView
        var not1: TextView
        var not2: TextView

        init {
            notCard = tasarim.findViewById(R.id.notCard)
            textDers = tasarim.findViewById(R.id.textDers)
            not1 = tasarim.findViewById(R.id.textNot1)
            not2 = tasarim.findViewById(R.id.textNot2)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.card_tasarim, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun getItemCount(): Int {
        return notlarList.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {

        val notlar = notlarList[position]

        holder.textDers.text = notlar.ders_adi
        holder.not1.text = (notlar.not1).toString()
        holder.not2.text = (notlar.not2).toString()

        holder.notCard.setOnClickListener {
            val intent=Intent(mContext,DetayActivity::class.java)
            intent.putExtra("nesne",notlar)
            mContext.startActivity(intent)
        }

    }


}