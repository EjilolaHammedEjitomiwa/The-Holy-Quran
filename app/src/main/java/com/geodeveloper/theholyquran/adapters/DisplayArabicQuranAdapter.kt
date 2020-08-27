package com.geodeveloper.theholyquran.adapters

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.geodeveloper.theholyquran.R
import com.geodeveloper.theholyquran.models.englishquran.AyahModel

class DisplayArabicQuranAdapter (val context: Context, val itemList: ArrayList<AyahModel>) : RecyclerView.Adapter<DisplayArabicQuranAdapter.ViewHolder?>() {
var mediaPlayer:MediaPlayer? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.d_quran_arabic_design, parent, false)
        mediaPlayer = MediaPlayer()
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val quran = itemList[position]
        holder.text.text = quran.text.toString()
        holder.number.text = quran.numberInSurah.toString()

        holder.playIcon.setOnClickListener {
            try {
                mediaPlayer!!.reset()
            }catch (e:IllegalStateException){}
            try {
                mediaPlayer!!.release()
            }catch (e:IllegalStateException){}

            mediaPlayer= MediaPlayer().apply {
                setAudioAttributes(AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
                )
                setDataSource(quran.audio)
                prepare()
                start()
            }
        }
        mediaPlayer!!.setOnCompletionListener(object :MediaPlayer.OnCompletionListener{
            override fun onCompletion(p0: MediaPlayer?) {
                try {
                    mediaPlayer!!.reset()
                }catch (e:IllegalStateException){}
                try {
                    mediaPlayer!!.release()
                }catch (e:IllegalStateException){}

            }
        })
        mediaPlayer!!.setOnPreparedListener(object :MediaPlayer.OnPreparedListener{
            override fun onPrepared(p0: MediaPlayer?) {
                Toast.makeText(context,"preparing",Toast.LENGTH_SHORT).show()
            }
        })
        mediaPlayer!!.setOnBufferingUpdateListener(object :MediaPlayer.OnBufferingUpdateListener{
            override fun onBufferingUpdate(p0: MediaPlayer?, p1: Int) {
                Toast.makeText(context,"buffering",Toast.LENGTH_SHORT).show()
            }
        })
        mediaPlayer!!.setOnErrorListener(object :MediaPlayer.OnErrorListener{
            override fun onError(p0: MediaPlayer?, p1: Int, p2: Int): Boolean {
                Toast.makeText(context,"error occur",Toast.LENGTH_SHORT).show()
                return true
            }

        })
    }
    inner class ViewHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text: TextView = itemView.findViewById(R.id.quran_arabic_design_text)
        val number:TextView = itemView.findViewById(R.id.quran_arabic_design_number)
        val playIcon:ImageView = itemView.findViewById(R.id.quran_arabic_design_playIcon)
    }
}