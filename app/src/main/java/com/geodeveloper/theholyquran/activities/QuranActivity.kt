package com.geodeveloper.theholyquran.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geodeveloper.theholyquran.R
import kotlinx.android.synthetic.main.activity_quran2.*

class QuranActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quran2)

        quran_activity_englishTranslation.setOnClickListener {
            startActivity(Intent(this,EnglishQuranActivity::class.java))
        }
        quran_activity_arabic.setOnClickListener {
            startActivity(Intent(this,ArabicQuranActivity::class.java))
        }
    }
}