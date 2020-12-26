package com.example.nflnotes.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GamesQuery(
    @SerializedName("\$query")
    @Expose val week: Week
) : Parcelable