package com.geodeveloper.theholyquran.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.geodeveloper.theholyquran.R
import com.geodeveloper.theholyquran.adapters.DisplayArabicQuranAdapter
import com.geodeveloper.theholyquran.adapters.DisplayEnglishQuranAdapter
import com.geodeveloper.theholyquran.models.englishquran.AyahModel
import kotlinx.android.synthetic.main.activity_english_quran.*
import kotlinx.android.synthetic.main.activity_read_arabic_quran.*
import java.lang.IllegalStateException

class ReadArabicQuran : AppCompatActivity() {
    var surah = ArrayList<AyahModel>()
    var ayahs = ArrayList<AyahModel>()
    private var adapter: DisplayArabicQuranAdapter? = null
    var arabicName: String? = null
    var englishName: String? = null
    var startPage: Int = 0
    var endPage: Int = 0
    var page: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_arabic_quran)

        surah = intent.getSerializableExtra("surah") as ArrayList<AyahModel>
        englishName = intent.getStringExtra("englishName")
        arabicName = intent.getStringExtra("arabicName")
        startPage = intent.getIntExtra("start_page", 0)
        endPage = intent.getIntExtra("end_page", 0)
        page = startPage

        arabic_quran_activity_arabicName.text = arabicName
        arabic_quran_activity_englishName.text = englishName

        adapter = DisplayArabicQuranAdapter(this, ayahs)
        arabic_quran_activity_recyclerview.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        arabic_quran_activity_recyclerview.layoutManager = layoutManager
        arabic_quran_activity_recyclerview.adapter = adapter

        getAyahLists()

        arabic_quran_activity_next.setOnClickListener {
            if (page < endPage) {
                page++
                getAyahLists()
                try {
                    adapter!!.mediaPlayer!!.reset()
                }catch (e:IllegalStateException){}
                try {
                    adapter!!.mediaPlayer!!.release()
                }catch (e:IllegalStateException){}

            } else {
                Toast.makeText(this, "limit reached", Toast.LENGTH_LONG).show()
            }

        }
        arabic_quran_activity_previous.setOnClickListener {
            if (page > startPage) {
                page--
                getAyahLists()
                try {
                    adapter!!.mediaPlayer!!.reset()
                }catch (e: IllegalStateException){}
                try {
                    adapter!!.mediaPlayer!!.release()
                }catch (e:IllegalStateException){}

            } else {
                Toast.makeText(this, "limit reached", Toast.LENGTH_LONG).show()
            }

        }
    }

    private fun getAyahLists() {
        ayahs.clear()
        for (ayah in surah) {
            if (ayah.page == page) {
                ayahs.add(ayah)
            }
        }
        if (ayahs.size <= 0) {
            Toast.makeText(this, "limit reached", Toast.LENGTH_LONG).show()
        }
        adapter!!.notifyDataSetChanged()
        arabic_quran_activity_recyclerview.scrollToPosition(0)
    }
}