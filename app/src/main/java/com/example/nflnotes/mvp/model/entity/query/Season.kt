package com.example.nflnotes.mvp.model.entity.query

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Season(
    @Expose val season: Int
): Parcelable