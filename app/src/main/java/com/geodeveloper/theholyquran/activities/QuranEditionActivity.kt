package com.geodeveloper.theholyquran.activities

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.geodeveloper.theholyquran.R
import com.geodeveloper.theholyquran.adapters.QuranEditionAdapters
import com.geodeveloper.theholyquran.models.quraneditions.QuranEditionModel
import com.geodeveloper.theholyquran.service.QuranService
import com.geodeveloper.theholyquran.service.ServiceBuilder
import com.jaredrummler.materialspinner.MaterialSpinner
import kotlinx.android.synthetic.main.activity_quran_edition.*
import kotlinx.android.synthetic.main.d_quran_edition_filter_dialogue.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.IllegalStateException

class QuranEditionActivity : AppCompatActivity() {
    var typeFilter:String? = null
    var formatFilter:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quran_edition)

        getQuranEditions()

        quran_edition_iconBack.setOnClickListener {
            finishAndRemoveTask()
        }
        quran_edition_iconFilter.setOnClickListener {
            val mDialogueView = LayoutInflater.from(this).inflate(R.layout.d_quran_edition_filter_dialogue, null)
            val mBuilder = AlertDialog.Builder(this).setView(mDialogueView)
            val mAlertDualogue = mBuilder.show()
            loadFilterOptions(mAlertDualogue.filter_dialogue_selectType,mAlertDualogue.filter_dialogue_selectFormat)
            mAlertDualogue.filter_dialogue_filterBtn.setOnClickListener {
                mAlertDualogue.dismiss()
                getQuranEditions(typeFilter,formatFilter)
                typeFilter = null
                formatFilter = null

                try {
                    quran_edition_progress.visibility = View.VISIBLE
                }catch (e:IllegalStateException){}
            }
        }
    }

    private fun getQuranEditions(filterByType:String? =null, filterByFormat:String? = null) {
        val filter = HashMap<String,String?>()
        var requestCall:Call<QuranEditionModel>
        val quranService = ServiceBuilder.buildService(QuranService::class.java)
        if(filterByType!= null){
            filter["type"] = filterByType
            requestCall = quranService.getQuranEditionsFilter(filter)
       }else if (filterByFormat != null){
            filter["format"] = filterByFormat
            requestCall = quranService.getQuranEditionsFilter(filter)
        }else if (filterByFormat != null && filterByType != null){
            filter["format"] = filterByFormat
            filter["type"] = filterByType
            requestCall = quranService.getQuranEditionsFilter(filter)
        }else{
            requestCall = quranService.getQuranEditions()
        }

        requestCall.enqueue(object : Callback<QuranEditionModel> {
            override fun onResponse(call: Call<QuranEditionModel>, response: Response<QuranEditionModel>) {
                if(response.isSuccessful){
                    val quranEditionLists = response.body()!!
                    quran_edition_recyclerView.adapter = QuranEditionAdapters(this@QuranEditionActivity, quranEditionLists)
                }
                try {
                    quran_edition_progress.visibility = View.GONE
                }catch (e:IllegalStateException){}
        }
            override fun onFailure(call: Call<QuranEditionModel>, t: Throwable) {
                Toast.makeText(this@QuranEditionActivity,"$t",Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun loadFilterOptions(filterByType: MaterialSpinner,filterByFormat: MaterialSpinner) {
        filterByType.setItems("tafsir", "translation", "quran","transliteration","versebyverse")
        filterByFormat.setItems("text", "audio")
        filterByType.setOnItemSelectedListener(object : MaterialSpinner.OnItemSelectedListener<String> {
            override fun onItemSelected(view: MaterialSpinner?, position: Int, id: Long, item: String?) {
                typeFilter = item!!
            }
        })
        filterByFormat.setOnItemSelectedListener(object : MaterialSpinner.OnItemSelectedListener<String> {
            override fun onItemSelected(view: MaterialSpinner?, position: Int, id: Long, item: String?) {
                formatFilter = item!!
            }
        })
    }

}