package com.example.nflnotes.mvp.model.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiHolder {

    val api: IDataSource by lazy {
        val gson = GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .create()

        Retrofit.Builder()
            .baseUrl("https://api.nfl.com/")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(IDataSource::class.java)
    }

}