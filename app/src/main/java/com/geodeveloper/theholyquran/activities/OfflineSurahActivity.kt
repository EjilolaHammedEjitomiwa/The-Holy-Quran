package com.geodeveloper.theholyquran.activities

import android.net.Uri
import android.os.Bundle
import android.os.Environment
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.geodeveloper.theholyquran.R
import com.geodeveloper.theholyquran.adapters.SurahListAdapter
import com.geodeveloper.theholyquran.models.SurahListModel
import com.geodeveloper.theholyquran.utils.Constants
import kotlinx.android.synthetic.main.activity_offline_surah.*
import java.io.File

class OfflineSurahActivity : AppCompatActivity() {

    private var imageList = ArrayList<SurahListModel>()
    private var adapter: SurahListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offline_surah)



        adapter = SurahListAdapter(this, imageList,true)
        offline_activity_recyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        offline_activity_recyclerView.layoutManager = layoutManager
        offline_activity_recyclerView.adapter = adapter

        getOfflineDownloadItems()
    }
    private fun getOfflineDownloadItems() {
        val folder_main = Constants.downloadFolderPath
        var image: SurahListModel
        val downloadFolder = File(Environment.getExternalStorageDirectory(), folder_main)
        if (downloadFolder.exists()) {
            imageList.clear()
            val files = downloadFolder.listFiles()
            for (element in files!!) {
                val file: File = element
                image =  SurahListModel()
                image.title = file.name
                image.uri = (Uri.fromFile(file))
                imageList.add(image)
                imageList.reverse()
            }
            adapter!!.notifyDataSetChanged()
        }
    }
}
