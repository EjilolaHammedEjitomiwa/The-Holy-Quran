package com.geodeveloper.theholyquran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geodeveloper.theholyquran.activities.AudioQuranListActivity
import com.geodeveloper.theholyquran.activities.EnglishQuranActivity
import com.geodeveloper.theholyquran.activities.QuranActivity
import com.geodeveloper.theholyquran.activities.QuranEditionActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_quranEditions.setOnClickListener {
            startActivity(Intent(this,QuranEditionActivity::class.java))
        }
        main_readQuran.setOnClickListener {
            startActivity(Intent(this,QuranActivity::class.java))
        }
        main_quranQudio.setOnClickListener {
            startActivity(Intent(this,AudioQuranListActivity::class.java))
        }
    }
}