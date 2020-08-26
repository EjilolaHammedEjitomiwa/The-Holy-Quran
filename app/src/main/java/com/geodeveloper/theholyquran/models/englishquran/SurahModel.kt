package com.geodeveloper.theholyquran.models.englishquran

import com.google.gson.annotations.SerializedName

 class SurahModel(val number: Int? = null,
                       val name: String? = null,
                       val englishName: String? = null,
                       val englishNameTranslation: String? = null,
                       val revelationType: String? = null,
                       @SerializedName("ayahs") val ayah: ArrayList<AyahModel>? = null) {
}