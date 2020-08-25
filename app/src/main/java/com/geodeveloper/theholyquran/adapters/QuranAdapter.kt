package com.geodeveloper.theholyquran.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.geodeveloper.theholyquran.R
import com.geodeveloper.theholyquran.models.quran.QuranModel


class QuranAdapter (val context: Context, val quranList: QuranModel) : RecyclerView.Adapter<QuranAdapter.ViewHolder?>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.d_quran_design, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return quranList.data!!.surah!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val quran = quranList.data!!.surah!![position]
        holder.name.text = quran.englishName
        holder.meaning.text = quran.englishNameTranslation
    }

    inner class ViewHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.quran_design_name)
        val meaning: TextView = itemView.findViewById(R.id.quran_design_englishMeaning)

    }
}