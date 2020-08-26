package com.geodeveloper.theholyquran.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.geodeveloper.theholyquran.R
import com.geodeveloper.theholyquran.adapters.ArabicQuranAdapter
import com.geodeveloper.theholyquran.adapters.DisplayArabicQuranAdapter
import com.geodeveloper.theholyquran.models.englishquran.QuranModel
import com.geodeveloper.theholyquran.service.QuranService
import com.geodeveloper.theholyquran.service.ServiceBuilder
import kotlinx.android.synthetic.main.activity_arabic_quran.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.IllegalStateException

class ArabicQuranActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arabic_quran)

        getQuranList()
    }

    private fun getQuranList() {
        val quranService = ServiceBuilder.buildService(QuranService::class.java)
        val requestCall = quranService.getArabicQuran()
        requestCall.enqueue(object : Callback<QuranModel> {
            override fun onResponse(call: Call<QuranModel>, response: Response<QuranModel>) {
                if (response.isSuccessful) {
                    val quranLists = response.body()!!
                    arabic_quran_activity_recyclerView.adapter = ArabicQuranAdapter(this@ArabicQuranActivity,quranLists)
                }
                try {
                    arabic_quran_activity_progress.visibility = View.GONE
                } catch (e: IllegalStateException) { }
            }
            override fun onFailure(call: Call<QuranModel>, t: Throwable) {
                Toast.makeText(this@ArabicQuranActivity, "$t", Toast.LENGTH_LONG).show()
            }
        })

    }
}