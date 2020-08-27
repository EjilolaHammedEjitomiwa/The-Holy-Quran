package com.geodeveloper.theholyquran.activities

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.net.toUri
import androidx.recyclerview.widget.LinearLayoutManager
import com.geodeveloper.theholyquran.R
import com.geodeveloper.theholyquran.adapters.SurahListAdapter
import com.geodeveloper.theholyquran.models.SurahListModel
import kotlinx.android.synthetic.main.activity_audio_quran_list.*

class AudioQuranListActivity : AppCompatActivity() {
    private var itemList = ArrayList<SurahListModel>()
    private var adapter: SurahListAdapter? = null
    private var isPermissionGranted = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio_quran_list)

        adapter = SurahListAdapter(this, itemList, false)
        audio_quran_recyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        audio_quran_recyclerView.layoutManager = layoutManager
        audio_quran_recyclerView.adapter = adapter

        itemList.add(SurahListModel("Surah Fatiha", "https://server6.mp3quran.net/kurdi/001.mp3", "".toUri()))
        itemList.add(SurahListModel("Surah Al Baqarah", "https://server6.mp3quran.net/kurdi/002.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Imran", "https://server6.mp3quran.net/kurdi/003.mp3", "".toUri()))
        itemList.add(SurahListModel("Yusuf", "https://server6.mp3quran.net/kurdi/012.mp3", "".toUri()))
        itemList.add(SurahListModel("Ar-Ra'd", "https://server6.mp3quran.net/kurdi/013.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Isra", "https://server6.mp3quran.net/kurdi/017.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Kahf", "https://server6.mp3quran.net/kurdi/018.mp3", "".toUri()))
        itemList.add(SurahListModel("Maryam", "https://server6.mp3quran.net/kurdi/019.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Anbiya", "https://server6.mp3quran.net/kurdi/021.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Hajj", "https://server6.mp3quran.net/kurdi/022.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Mu'minun", "https://server6.mp3quran.net/kurdi/023.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Furqan", "https://server6.mp3quran.net/kurdi/025.mp3", "".toUri()))
        itemList.add(SurahListModel("Ash-Shu'ara", "https://server6.mp3quran.net/kurdi/026.mp3", "".toUri()))
        itemList.add(SurahListModel("An-Naml", "https://server6.mp3quran.net/kurdi/027.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Qasas", "https://server6.mp3quran.net/kurdi/028.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-'Ankabut", "https://server6.mp3quran.net/kurdi/029.mp3", "".toUri()))
        itemList.add(SurahListModel("ArRoom", "https://server6.mp3quran.net/kurdi/030.mp3", "".toUri()))
        itemList.add(SurahListModel("Luqman", "https://server6.mp3quran.net/kurdi/031.mp3", "".toUri()))
        itemList.add(SurahListModel("As Sajdah", "https://server6.mp3quran.net/kurdi/032.mp3", "".toUri()))
        itemList.add(SurahListModel("AlAhzab", "https://server6.mp3quran.net/kurdi/033.mp3", "".toUri()))
        itemList.add(SurahListModel("Fatir", "https://server6.mp3quran.net/kurdi/035.mp3", "".toUri()))
        itemList.add(SurahListModel("YaSin", "https://server6.mp3quran.net/kurdi/036.mp3", "".toUri()))
        itemList.add(SurahListModel("Sad", "https://server6.mp3quran.net/kurdi/038.mp3", "".toUri()))
        itemList.add(SurahListModel("Az-Zumar", "https://server6.mp3quran.net/kurdi/039.mp3", "".toUri()))
        itemList.add(SurahListModel("Fussilat", "https://server6.mp3quran.net/kurdi/041.mp3", "".toUri()))
        itemList.add(SurahListModel("Ash-Shura", "https://server6.mp3quran.net/kurdi/042.mp3", "".toUri()))
        itemList.add(SurahListModel("Az-Zukhruf", "https://server6.mp3quran.net/kurdi/043.mp3", "".toUri()))
        itemList.add(SurahListModel("Ad-Dukhan", "https://server6.mp3quran.net/kurdi/044.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Ahqaf", "https://server6.mp3quran.net/kurdi/046.mp3", "".toUri()))
        itemList.add(SurahListModel("Muhammad", "https://server6.mp3quran.net/kurdi/047.mp3", "".toUri()))
        itemList.add(SurahListModel("Az-Zariyat", "https://server6.mp3quran.net/kurdi/051.mp3", "".toUri()))
        itemList.add(SurahListModel("At-Tur", "https://server6.mp3quran.net/kurdi/052.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Waqi'ah", "https://server6.mp3quran.net/kurdi/056.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Hadid", "https://server6.mp3quran.net/kurdi/057.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Mujadilah", "https://server6.mp3quran.net/kurdi/058.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Hashr", "https://server6.mp3quran.net/kurdi/059.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Mumtahinah", "https://server6.mp3quran.net/kurdi/060.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Jumu'ah", "https://server6.mp3quran.net/kurdi/062.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Munafiqun", "https://server6.mp3quran.net/kurdi/063.mp3", "".toUri()))
        itemList.add(SurahListModel("At-Taghabun", "https://server6.mp3quran.net/kurdi/064.mp3", "".toUri()))
        itemList.add(SurahListModel("At-Talaq", "https://server6.mp3quran.net/kurdi/065.mp3", "".toUri()))
        itemList.add(SurahListModel("At-Tahrim", "https://server6.mp3quran.net/kurdi/066.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Mulk", "https://server6.mp3quran.net/kurdi/067.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Qalam", "https://server6.mp3quran.net/kurdi/068.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Haqqah", "https://server6.mp3quran.net/kurdi/069.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Ma'arij", "https://server6.mp3quran.net/kurdi/070.mp3", "".toUri()))
        itemList.add(SurahListModel("Nooh", "https://server6.mp3quran.net/kurdi/071.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Jinn", "https://server6.mp3quran.net/kurdi/072.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Muzzammil", "https://server6.mp3quran.net/kurdi/073.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Muddaththir", "https://server6.mp3quran.net/kurdi/074.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Qiyamah", "https://server6.mp3quran.net/kurdi/075.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Insan", "https://server6.mp3quran.net/kurdi/076.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Mursalat", "https://server6.mp3quran.net/kurdi/077.mp3", "".toUri()))
        itemList.add(SurahListModel("An-Naba'", "https://server6.mp3quran.net/kurdi/078.mp3", "".toUri()))
        itemList.add(SurahListModel("An-Nazi'at", "https://server6.mp3quran.net/kurdi/079.mp3", "".toUri()))
        itemList.add(SurahListModel("'Abasa", "https://server6.mp3quran.net/kurdi/080.mp3", "".toUri()))
        itemList.add(SurahListModel("'At-Takwir", "https://server6.mp3quran.net/kurdi/081.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Infitar", "https://server6.mp3quran.net/kurdi/082.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Mutaffifin", "https://server6.mp3quran.net/kurdi/083.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Inshiqaq", "https://server6.mp3quran.net/kurdi/084.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Buruj", "https://server6.mp3quran.net/kurdi/085.mp3", "".toUri()))
        itemList.add(SurahListModel("At-Tariq", "https://server6.mp3quran.net/kurdi/086.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-A'la", "https://server6.mp3quran.net/kurdi/087.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Ghashiyah", "https://server6.mp3quran.net/kurdi/088.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Fajr", "https://server6.mp3quran.net/kurdi/089.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Balad", "https://server6.mp3quran.net/kurdi/090.mp3", "".toUri()))
        itemList.add(SurahListModel("Ash-Shams", "https://server6.mp3quran.net/kurdi/091.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Lail", "https://server6.mp3quran.net/kurdi/092.mp3", "".toUri()))
        itemList.add(SurahListModel("Ad-Duha", "https://server6.mp3quran.net/kurdi/093.mp3", "".toUri()))
        itemList.add(SurahListModel("Ash-Sharh", "https://server6.mp3quran.net/kurdi/094.mp3", "".toUri()))
        itemList.add(SurahListModel("At-Tin", "https://server6.mp3quran.net/kurdi/095.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-'Alaq", "https://server6.mp3quran.net/kurdi/096.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Qadr", "https://server6.mp3quran.net/kurdi/097.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Baiyinah", "https://server6.mp3quran.net/kurdi/098.mp3", "".toUri()))
        itemList.add(SurahListModel("Az-Zalzalah", "https://server6.mp3quran.net/kurdi/099.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-'Adiyat", "https://server6.mp3quran.net/kurdi/100.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Qari'ah", "https://server6.mp3quran.net/kurdi/101.mp3", "".toUri()))
        itemList.add(SurahListModel("At-Takathur", "https://server6.mp3quran.net/kurdi/102.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-'Asr", "https://server6.mp3quran.net/kurdi/103.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Humazah", "https://server6.mp3quran.net/kurdi/104.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Fil", "https://server6.mp3quran.net/kurdi/105.mp3", "".toUri()))
        itemList.add(SurahListModel("Quraish", "https://server6.mp3quran.net/kurdi/106.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Ma'un", "https://server6.mp3quran.net/kurdi/107.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Kauthar", "https://server6.mp3quran.net/kurdi/108.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Kafirun", "https://server6.mp3quran.net/kurdi/109.mp3", "".toUri()))
        itemList.add(SurahListModel("An-Nasr", "https://server6.mp3quran.net/kurdi/110.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Masad", "https://server6.mp3quran.net/kurdi/111.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Ikhlas", "https://server6.mp3quran.net/kurdi/112.mp3", "".toUri()))
        itemList.add(SurahListModel("Al-Falaq", "https://server6.mp3quran.net/kurdi/113.mp3", "".toUri()))
        itemList.add(SurahListModel("An-Nas", "https://server6.mp3quran.net/kurdi/114.mp3", "".toUri()))

        adapter!!.notifyDataSetChanged()
        isStoragePermissionGranted()
    }

    private fun isStoragePermissionGranted(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                isPermissionGranted = true
                true
            } else {
                ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        1
                )
                false
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            // Log.v(FragmentActivity.TAG, "Permission is granted")
            isPermissionGranted = true
            true
        }
    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

        }
    }
}