package com.example.nflnotes.mvp.model.entity.response

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TeamsResponse(
    @SerializedName("data")
    @Expose val teams: List<Team>?
): Parcelable