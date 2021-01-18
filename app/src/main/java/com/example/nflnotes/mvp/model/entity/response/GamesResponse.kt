package com.example.nflnotes.mvp.model.entity.response

import android.os.Parcelable
import com.example.nflnotes.mvp.model.entity.Game
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GamesResponse(
    @SerializedName("data")
    @Expose val games: List<Game>?
): Parcelable