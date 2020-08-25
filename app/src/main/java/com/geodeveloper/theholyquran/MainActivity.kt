package com.geodeveloper.theholyquran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geodeveloper.theholyquran.activities.QuranEditionActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_quranEditions.setOnClickListener {
            startActivity(Intent(this,QuranEditionActivity::class.java))
        }
    }
}