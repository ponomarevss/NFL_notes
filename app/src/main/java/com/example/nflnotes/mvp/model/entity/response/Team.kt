package com.example.nflnotes.mvp.model.entity.response

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Team(
    @Expose val id: String?,
    @Expose val fullName: String?,
    @Expose val nickName: String?,
    @Expose val abbr: String?,
    @Expose val cityStateRegion: String?
): Parcelable
