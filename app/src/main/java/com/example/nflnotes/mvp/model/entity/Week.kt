package com.example.nflnotes.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Week(
    @SerializedName("week.season")
    @Expose val season: Int = 2018,
    @SerializedName("week.seasonType")
    @Expose val seasonType: String = "REG",
    @SerializedName("week.week")
    @Expose val week: Int = 6
) : Parcelable