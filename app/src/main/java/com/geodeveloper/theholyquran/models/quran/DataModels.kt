package com.geodeveloper.theholyquran.models.quran

import com.google.gson.annotations.SerializedName

class DataModels(@SerializedName("surahs") val surah:List<SurahModel>? = null) {
}