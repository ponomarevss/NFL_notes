package com.example.nflnotes.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Score(
    @Expose val pointsTotal: Int?
): Parcelable