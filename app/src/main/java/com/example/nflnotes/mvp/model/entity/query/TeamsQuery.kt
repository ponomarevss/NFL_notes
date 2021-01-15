package com.example.nflnotes.mvp.model.entity.games

import android.os.Parcelable
import com.example.nflnotes.mvp.model.entity.query.Season
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TeamsQuery(
    @SerializedName("\$query")
    @Expose val season: Season
) : Parcelable