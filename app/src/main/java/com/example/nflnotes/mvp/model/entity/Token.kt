package com.example.nflnotes.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Token(
    @Expose val accessToken: String?,
    @Expose val tokenType: String?,
    @Expose val expiresIn: Int?,
    @Expose val gigyaUID: String?
) : Parcelable
