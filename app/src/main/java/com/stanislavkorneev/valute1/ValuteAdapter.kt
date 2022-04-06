package com.stanislavkorneev.valute1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ValuteAdapter : RecyclerView.Adapter<ValuteAdapter.ValuteHolder>() {
    var valutes : List<Valute> = ArrayList<Valute>()

    //создает ViewHolder и инициализирует views для списка
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ValuteHolder {
        return ValuteHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.valute_item, parent, false)
        )
    }

    //связывает views с содержимым
    override fun onBindViewHolder(viewHolder: ValuteHolder, position: Int) {
        viewHolder.bind(valutes[position])
    }

    override fun getItemCount() = valutes.size

    //внутренний класс ViewHolder описывает элементы представления списка и привязку их к RecyclerView
    class ValuteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(valute: Valute) {
            itemView.findViewById<TextView>(R.id.valuteText).text = valute.toString()
        }
    }
}