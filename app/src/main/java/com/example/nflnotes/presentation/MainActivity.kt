package com.example.nflnotes.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.nflnotes.R
import com.example.nflnotes.data.provider.HtmlDataProvider

class MainActivity : AppCompatActivity() {

    companion object {
        private const val BASE_URL = "https://www.cbssports.com/nfl/scoreboard/2020/regular/1/"
    }
    lateinit var viewModel: MainViewModel
    lateinit var adapter: MainRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

//        val htmlDataProvider = HtmlDataProvider()
//        htmlDataProvider.getGames(BASE_URL)
    }
}
/*
            val url = URL(BASE_URL)
            val urlConnection = url.openConnection() as HttpsURLConnection
            try {
                val text = urlConnection.inputStream.bufferedReader().readText()
                val file = File(getExternalFilesDir(null), "nlf202001.mhtml")
                val bufferedWriter = BufferedWriter(FileWriter(file))
                bufferedWriter.write(text)
                bufferedWriter.close()
            } finally {
                urlConnection.disconnect()
            }
*/