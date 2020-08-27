package com.geodeveloper.theholyquran.activities

import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jean.jcplayer.JcPlayerManagerListener
import com.example.jean.jcplayer.general.JcStatus
import com.example.jean.jcplayer.general.errors.OnInvalidPathListener
import com.example.jean.jcplayer.model.JcAudio
import com.example.jean.jcplayer.view.JcPlayerView
import com.geodeveloper.theholyquran.R
import com.geodeveloper.theholyquran.models.SurahListModel
import com.geodeveloper.theholyquran.utils.Constants
import java.io.File

class PlayerActivity : AppCompatActivity(), OnInvalidPathListener, JcPlayerManagerListener {
    private val jcAudios = ArrayList<JcAudio>()
    private var itemList = ArrayList<SurahListModel>()
    private var position = 0
    private var isOffline = false
    private var jcPlayerView: JcPlayerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        jcPlayerView = findViewById(R.id.playerView)

        position = intent.getIntExtra("position", 0)
        isOffline = intent.getBooleanExtra("is_offline", false)

        if (isOffline) {
            val folder_main = Constants.downloadFolderPath
            var image: SurahListModel
            val downloadFolder = File(Environment.getExternalStorageDirectory(), folder_main)
            if (downloadFolder.exists()) {
                jcAudios.clear()
                val files = downloadFolder.listFiles()
                for (element in files!!) {
                    val file: File = element
                    image = SurahListModel()
                    jcAudios.add(JcAudio.createFromFilePath(file.name, file.path));
                    jcAudios.reverse()
                }
            }
        } else {
            jcAudios.add(JcAudio.createFromURL("Surah Fatiha", "https://server6.mp3quran.net/kurdi/001.mp3"))
            jcAudios.add(JcAudio.createFromURL("Surah Al Baqarah", "https://server6.mp3quran.net/kurdi/002.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Imran", "https://server6.mp3quran.net/kurdi/003.mp3"))
            jcAudios.add(JcAudio.createFromURL("Yusuf", "https://server6.mp3quran.net/kurdi/012.mp3"))
            jcAudios.add(JcAudio.createFromURL("Ar-Ra'd", "https://server6.mp3quran.net/kurdi/013.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Isra", "https://server6.mp3quran.net/kurdi/017.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Kahf", "https://server6.mp3quran.net/kurdi/018.mp3"))
            jcAudios.add(JcAudio.createFromURL("Maryam", "https://server6.mp3quran.net/kurdi/019.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Anbiya", "https://server6.mp3quran.net/kurdi/021.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Hajj", "https://server6.mp3quran.net/kurdi/022.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Mu'minun", "https://server6.mp3quran.net/kurdi/023.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Furqan", "https://server6.mp3quran.net/kurdi/025.mp3"))
            jcAudios.add(JcAudio.createFromURL("Ash-Shu'ara", "https://server6.mp3quran.net/kurdi/026.mp3"))
            jcAudios.add(JcAudio.createFromURL("An-Naml", "https://server6.mp3quran.net/kurdi/027.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Qasas", "https://server6.mp3quran.net/kurdi/028.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-'Ankabut", "https://server6.mp3quran.net/kurdi/029.mp3"))
            jcAudios.add(JcAudio.createFromURL("ArRoom", "https://server6.mp3quran.net/kurdi/030.mp3"))
            jcAudios.add(JcAudio.createFromURL("Luqman", "https://server6.mp3quran.net/kurdi/031.mp3"))
            jcAudios.add(JcAudio.createFromURL("As Sajdah", "https://server6.mp3quran.net/kurdi/032.mp3"))
            jcAudios.add(JcAudio.createFromURL("AlAhzab", "https://server6.mp3quran.net/kurdi/033.mp3"))
            jcAudios.add(JcAudio.createFromURL("Fatir", "https://server6.mp3quran.net/kurdi/035.mp3"))
            jcAudios.add(JcAudio.createFromURL("YaSin", "https://server6.mp3quran.net/kurdi/036.mp3"))
            jcAudios.add(JcAudio.createFromURL("Sad", "https://server6.mp3quran.net/kurdi/038.mp3"))
            jcAudios.add(JcAudio.createFromURL("Az-Zumar", "https://server6.mp3quran.net/kurdi/039.mp3"))
            jcAudios.add(JcAudio.createFromURL("Fussilat", "https://server6.mp3quran.net/kurdi/041.mp3"))
            jcAudios.add(JcAudio.createFromURL("Ash-Shura", "https://server6.mp3quran.net/kurdi/042.mp3"))
            jcAudios.add(JcAudio.createFromURL("Az-Zukhruf", "https://server6.mp3quran.net/kurdi/043.mp3"))
            jcAudios.add(JcAudio.createFromURL("Ad-Dukhan", "https://server6.mp3quran.net/kurdi/044.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Ahqaf", "https://server6.mp3quran.net/kurdi/046.mp3"))
            jcAudios.add(JcAudio.createFromURL("Muhammad", "https://server6.mp3quran.net/kurdi/047.mp3"))
            jcAudios.add(JcAudio.createFromURL("Az-Zariyat", "https://server6.mp3quran.net/kurdi/051.mp3"))
            jcAudios.add(JcAudio.createFromURL("At-Tur", "https://server6.mp3quran.net/kurdi/052.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Waqi'ah", "https://server6.mp3quran.net/kurdi/056.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Hadid", "https://server6.mp3quran.net/kurdi/057.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Mujadilah", "https://server6.mp3quran.net/kurdi/058.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Hashr", "https://server6.mp3quran.net/kurdi/059.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Mumtahinah", "https://server6.mp3quran.net/kurdi/060.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Jumu'ah", "https://server6.mp3quran.net/kurdi/062.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Munafiqun", "https://server6.mp3quran.net/kurdi/063.mp3"))
            jcAudios.add(JcAudio.createFromURL("At-Taghabun", "https://server6.mp3quran.net/kurdi/064.mp3"))
            jcAudios.add(JcAudio.createFromURL("At-Talaq", "https://server6.mp3quran.net/kurdi/065.mp3"))
            jcAudios.add(JcAudio.createFromURL("At-Tahrim", "https://server6.mp3quran.net/kurdi/066.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Mulk", "https://server6.mp3quran.net/kurdi/067.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Qalam", "https://server6.mp3quran.net/kurdi/068.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Haqqah", "https://server6.mp3quran.net/kurdi/069.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Ma'arij", "https://server6.mp3quran.net/kurdi/070.mp3"))
            jcAudios.add(JcAudio.createFromURL("Nooh", "https://server6.mp3quran.net/kurdi/071.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Jinn", "https://server6.mp3quran.net/kurdi/072.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Muzzammil", "https://server6.mp3quran.net/kurdi/073.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Muddaththir", "https://server6.mp3quran.net/kurdi/074.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Qiyamah", "https://server6.mp3quran.net/kurdi/075.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Insan", "https://server6.mp3quran.net/kurdi/076.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Mursalat", "https://server6.mp3quran.net/kurdi/077.mp3"))
            jcAudios.add(JcAudio.createFromURL("An-Naba'", "https://server6.mp3quran.net/kurdi/078.mp3"))
            jcAudios.add(JcAudio.createFromURL("An-Nazi'at", "https://server6.mp3quran.net/kurdi/079.mp3"))
            jcAudios.add(JcAudio.createFromURL("'Abasa", "https://server6.mp3quran.net/kurdi/080.mp3"))
            jcAudios.add(JcAudio.createFromURL("'At-Takwir", "https://server6.mp3quran.net/kurdi/081.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Infitar", "https://server6.mp3quran.net/kurdi/082.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Mutaffifin", "https://server6.mp3quran.net/kurdi/083.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Inshiqaq", "https://server6.mp3quran.net/kurdi/084.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Buruj", "https://server6.mp3quran.net/kurdi/085.mp3"))
            jcAudios.add(JcAudio.createFromURL("At-Tariq", "https://server6.mp3quran.net/kurdi/086.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-A'la", "https://server6.mp3quran.net/kurdi/087.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Ghashiyah", "https://server6.mp3quran.net/kurdi/088.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Fajr", "https://server6.mp3quran.net/kurdi/089.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Balad", "https://server6.mp3quran.net/kurdi/090.mp3"))
            jcAudios.add(JcAudio.createFromURL("Ash-Shams", "https://server6.mp3quran.net/kurdi/091.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Lail", "https://server6.mp3quran.net/kurdi/092.mp3"))
            jcAudios.add(JcAudio.createFromURL("Ad-Duha", "https://server6.mp3quran.net/kurdi/093.mp3"))
            jcAudios.add(JcAudio.createFromURL("Ash-Sharh", "https://server6.mp3quran.net/kurdi/094.mp3"))
            jcAudios.add(JcAudio.createFromURL("At-Tin", "https://server6.mp3quran.net/kurdi/095.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-'Alaq", "https://server6.mp3quran.net/kurdi/096.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Qadr", "https://server6.mp3quran.net/kurdi/097.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Baiyinah", "https://server6.mp3quran.net/kurdi/098.mp3"))
            jcAudios.add(JcAudio.createFromURL("Az-Zalzalah", "https://server6.mp3quran.net/kurdi/099.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-'Adiyat", "https://server6.mp3quran.net/kurdi/100.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Qari'ah", "https://server6.mp3quran.net/kurdi/101.mp3"))
            jcAudios.add(JcAudio.createFromURL("At-Takathur", "https://server6.mp3quran.net/kurdi/102.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-'Asr", "https://server6.mp3quran.net/kurdi/103.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Humazah", "https://server6.mp3quran.net/kurdi/104.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Fil", "https://server6.mp3quran.net/kurdi/105.mp3"))
            jcAudios.add(JcAudio.createFromURL("Quraish", "https://server6.mp3quran.net/kurdi/106.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Ma'un", "https://server6.mp3quran.net/kurdi/107.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Kauthar", "https://server6.mp3quran.net/kurdi/108.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Kafirun", "https://server6.mp3quran.net/kurdi/109.mp3"))
            jcAudios.add(JcAudio.createFromURL("An-Nasr", "https://server6.mp3quran.net/kurdi/110.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Masad", "https://server6.mp3quran.net/kurdi/111.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Ikhlas", "https://server6.mp3quran.net/kurdi/112.mp3"))
            jcAudios.add(JcAudio.createFromURL("Al-Falaq", "https://server6.mp3quran.net/kurdi/113.mp3"))
            jcAudios.add(JcAudio.createFromURL("An-Nas", "https://server6.mp3quran.net/kurdi/114.mp3"))
        }

        jcPlayerView!!.initPlaylist(jcAudios, this@PlayerActivity)
        jcPlayerView!!.playAudio(jcAudios[position])
    }


    override fun onPathError(jcAudio: JcAudio) {
        Toast.makeText(this, "Path Error", Toast.LENGTH_LONG).show()
    }

    override fun onCompletedAudio() {
        position++
        try {
            jcPlayerView!!.playAudio(jcAudios[position])
        } catch (e: IndexOutOfBoundsException) {
            Toast.makeText(this, "last surah reached", Toast.LENGTH_LONG).show()
        }

    }

    override fun onContinueAudio(status: JcStatus) {

    }

    override fun onJcpError(throwable: Throwable) {
    }

    override fun onPaused(status: JcStatus) {
    }

    override fun onPlaying(status: JcStatus) {
    }

    override fun onPreparedAudio(status: JcStatus) {
        if (!isOffline) {
            Toast.makeText(this, "buffering", Toast.LENGTH_LONG).show()
        }

    }

    override fun onStopped(status: JcStatus) {
    }

    override fun onTimeChanged(status: JcStatus) {
    }

    override fun onStop() {
        super.onStop()
      //  jcPlayerView!!.createNotification(R.drawable.)
    }

    override fun onPause() {
        super.onPause()
      //  jcPlayerView!!.createNotification(R.drawable.raadal_kurdi)
    }

    override fun finish() {
        super.finish()
        jcPlayerView!!.createNotification()
    }

    override fun onDestroy() {
        super.onDestroy()
       // jcPlayerView!!.createNotification(R.drawable.raadal_kurdi)
    }
}
