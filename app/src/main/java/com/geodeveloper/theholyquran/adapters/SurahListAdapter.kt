package com.geodeveloper.theholyquran.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.renderscript.RenderScript.Priority
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.developer.kalert.KAlertDialog
import com.download.library.DownloadImpl
import com.download.library.DownloadListenerAdapter
import com.download.library.Extra
import com.geodeveloper.theholyquran.R
import com.geodeveloper.theholyquran.activities.PlayerActivity
import com.geodeveloper.theholyquran.models.SurahListModel
import com.geodeveloper.theholyquran.utils.Constants
import com.mikhaellopez.circularprogressbar.CircularProgressBar
import com.tonyodev.fetch2.*
import org.jetbrains.annotations.NotNull
import java.io.File
import kotlin.Error


@Suppress("DEPRECATION")
class SurahListAdapter(val context: Context, val surahList: ArrayList<SurahListModel>, val isOffline: Boolean) : RecyclerView.Adapter<SurahListAdapter.ViewHolder?>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.d_sural_list_design, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return surahList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = surahList[position]
        checkIfIsDownloaded(item.title, holder.downloadedText)
        try {
            holder.title.text = item.title
        } catch (e: Exception) {
        }

        if (isOffline) {
            holder.donwloadIcon.visibility = View.GONE
            holder.deleteIcon.visibility = View.VISIBLE
            holder.downloadedText.visibility = View.VISIBLE
        }

        holder.container.setOnClickListener {
            var value = false
            if (isOffline) {
                value = true
            }
            val intent = Intent(context, PlayerActivity::class.java)
            intent.putExtra("position", position)
            intent.putExtra("is_offline", value)
            context.startActivity(intent)
        }
        holder.donwloadIcon.setOnClickListener {
            startDownload(item.title, item.url, holder.progressBar)
        }
        holder.deleteIcon.setOnClickListener {
            KAlertDialog(context, KAlertDialog.WARNING_TYPE)
                    .setTitleText("Warning")
                    .setContentText("Are you sure you want to remove this surah from your download list")
                    .setConfirmText("Yes remove")
                    .setCancelText("Cancel")
                    .confirmButtonColor(R.color.colorPrimary)
                    .cancelButtonColor(R.color.colorPrimary)
                    .setConfirmClickListener {
                        it.dismiss()
                        removeSurahFromOffline(item.uri)
                    }.setCancelClickListener {
                        it.dismiss()
                    }
                    .show()
        }


    }

    private fun removeSurahFromOffline(uri: Uri) {
        val file = File(uri.path!!)
        try {
            file.delete()
            Toast.makeText(context, "Successfully removed", Toast.LENGTH_LONG).show()
            notifyDataSetChanged()
        } catch (e: Exception) {
        }
    }

    private fun checkIfIsDownloaded(title: String, downloadedText: TextView) {
        try {
            val folder_main =Constants.downloadFolderPath
            val downloadFolder = File(Environment.getExternalStorageDirectory(), folder_main)
            if (downloadFolder.exists()) {
                val files = downloadFolder.listFiles()
                for (element in files!!) {
                    val file: File = element
                    if ("$title.mp3" == file.name) {
                        downloadedText.visibility = View.VISIBLE
                    }else{
                        downloadedText.visibility = View.GONE
                    }
                }
            }
        } catch (e: Exception) {
        }
    }

    private fun startDownload(title: String, url: String, progressBar: CircularProgressBar) {

        val folder_main = Constants.downloadFolderPath
        val f = File(Environment.getExternalStorageDirectory(), folder_main)
        if (!f.exists()) {
            f.mkdirs()
        }
        val outPath = File("$f/$title.mp3")
        val fetchConfiguration: FetchConfiguration = FetchConfiguration.Builder(context).setDownloadConcurrentLimit(3).build()
        val fetch = Fetch.Impl.getInstance(fetchConfiguration);
        val url = url
        val file = outPath

        val request = Request(url,file.toUri())
        request.addHeader("clientKey", "SD78DF93_3947&MVNGHE1WONG")






    }
    inner class ViewHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {
        val container: LinearLayout = itemView.findViewById(R.id.surah_design_container)
        val title: TextView = itemView.findViewById(R.id.surah_design_title)
        val donwloadIcon: ImageView = itemView.findViewById(R.id.surah_design_DownloadIcon)
        val deleteIcon: ImageView = itemView.findViewById(R.id.surah_design_deleteIcon)
        val downloadedText: TextView = itemView.findViewById(R.id.surah_design_downloadedText)
        val progressBar: CircularProgressBar = itemView.findViewById(R.id.surah_design_progressBar)
    }
}