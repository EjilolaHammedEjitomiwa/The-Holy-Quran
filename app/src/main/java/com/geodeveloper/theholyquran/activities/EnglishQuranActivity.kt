package com.geodeveloper.theholyquran.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.geodeveloper.theholyquran.R
import com.geodeveloper.theholyquran.adapters.EnglishQuranAdapter
import com.geodeveloper.theholyquran.models.englishquran.QuranModel
import com.geodeveloper.theholyquran.service.QuranService
import com.geodeveloper.theholyquran.service.ServiceBuilder
import kotlinx.android.synthetic.main.activity_quran.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.IllegalStateException

class EnglishQuranActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quran)

        getQuranList()

        quran_activity_iconSearch.setOnClickListener {
            quran_activity_searchContainer.visibility = View.VISIBLE
        }
    }

    private fun getQuranList() {
        val quranService = ServiceBuilder.buildService(QuranService::class.java)
        val requestCall = quranService.getEnglishQuran()
        requestCall.enqueue(object : Callback<QuranModel> {
            override fun onResponse(call: Call<QuranModel>, response: Response<QuranModel>) {
                if (response.isSuccessful) {
                    val quranLists = response.body()!!
                    quran_activity_recyclerView.adapter = EnglishQuranAdapter(this@EnglishQuranActivity,quranLists)
                }
                try {
                    quran_activity_progress.visibility = View.GONE
                } catch (e: IllegalStateException) { }
            }
            override fun onFailure(call: Call<QuranModel>, t: Throwable) {
                Toast.makeText(this@EnglishQuranActivity, "$t", Toast.LENGTH_LONG).show()
            }
        })

    }
}