package com.example.nflnotes.mvp.model.entity.query

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Token(
    @SerializedName("access_token")
    @Expose val accessToken: String?
) : Parcelable