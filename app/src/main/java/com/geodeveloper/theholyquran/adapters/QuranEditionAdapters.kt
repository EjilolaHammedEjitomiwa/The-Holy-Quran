package com.geodeveloper.theholyquran.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.geodeveloper.theholyquran.R
import com.geodeveloper.theholyquran.models.QuranEditionModel

class QuranEditionAdapters(val context: Context, val editionLists:QuranEditionModel):
    RecyclerView.Adapter<QuranEditionAdapters.ViewHolder?>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.d_quran_edition_design,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return editionLists.results!!.size
    }
    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        val edition  = editionLists.results!![position]
        holder.title.text = edition.englishName
    }

    inner class ViewHolder(@NonNull itemView: View): RecyclerView.ViewHolder(itemView){
        val title: TextView = itemView.findViewById(R.id.quran_edition_name)
        val container: LinearLayout = itemView.findViewById(R.id.quran_edition_container)

    }
}