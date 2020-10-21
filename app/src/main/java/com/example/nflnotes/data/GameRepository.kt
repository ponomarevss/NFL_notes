package com.example.nflnotes.data

import com.example.nflnotes.data.provider.HtmlDataProvider
import com.example.nflnotes.data.provider.IDataProvider

object GameRepository {

    val dataProvider: IDataProvider = HtmlDataProvider()
}