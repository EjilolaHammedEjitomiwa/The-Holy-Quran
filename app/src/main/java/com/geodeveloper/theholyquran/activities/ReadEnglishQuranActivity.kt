package com.geodeveloper.theholyquran.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.geodeveloper.theholyquran.R
import com.geodeveloper.theholyquran.adapters.DisplayEnglishQuranAdapter
import com.geodeveloper.theholyquran.models.englishquran.AyahModel
import kotlinx.android.synthetic.main.activity_english_quran.*

class ReadEnglishQuranActivity : AppCompatActivity() {
    var surah = ArrayList<AyahModel>()
    var ayahs = ArrayList<AyahModel>()
    private var adapter: DisplayEnglishQuranAdapter? = null
    var arabicName:String? = null
    var englishName:String? = null
    var startPage:Int = 0
    var endPage:Int = 0
    var page:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_english_quran)

        surah = intent.getSerializableExtra("surah") as ArrayList<AyahModel>
        englishName = intent.getStringExtra("englishName")
        arabicName = intent.getStringExtra("arabicName")
        startPage = intent.getIntExtra("start_page",0)
        endPage = intent.getIntExtra("end_page",0)
        page = startPage

        english_quran_activity_arabicName.text = arabicName
        english_quran_activity_englishName.text = englishName

        adapter = DisplayEnglishQuranAdapter(this, ayahs)
        english_quran_activity_recyclerview.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        english_quran_activity_recyclerview.layoutManager = layoutManager
        english_quran_activity_recyclerview.adapter = adapter

        getAyahLists()

        english_quran_activity_next.setOnClickListener {
            if(page < endPage){
                page++
                getAyahLists()
            }else{
                Toast.makeText(this,"limit reached",Toast.LENGTH_LONG).show()
            }

        }
        english_quran_activity_previous.setOnClickListener {
            if(page > startPage){
                page--
                getAyahLists()
            }else{
                Toast.makeText(this,"limit reached",Toast.LENGTH_LONG).show()
            }

        }


    }

    private fun getAyahLists() {
        ayahs.clear()
        for(ayah in surah){
            if(ayah.page == page){
                ayahs.add(ayah)
            }
        }
        if(ayahs.size <= 0){
            Toast.makeText(this,"limit reached",Toast.LENGTH_LONG).show()
        }
        adapter!!.notifyDataSetChanged()
    }
}