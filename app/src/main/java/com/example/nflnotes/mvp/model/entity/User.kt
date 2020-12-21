package com.example.nflnotes.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    @Expose val username: String = "Aagoroh85",
    @Expose val password: String = "Aagoroh85",
    @Expose val firstName: String = "Sergey",
    @Expose val lastName: String = "Ponomarev",
    @Expose val emailAddress: String = "dev.ponomarevss@gmail.com",
    @Expose val birthDay: Int = 18,
    @Expose val birthMonth: Int = 7,
    @Expose val birthYear: Int = 1980,
    @Expose val optIn: Boolean = false,
    @Expose val tos: Boolean = true,
    ) : Parcelable
