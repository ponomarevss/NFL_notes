package com.example.nflnotes.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.nflnotes.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jsoup.Jsoup

class MainActivity : AppCompatActivity() {

    companion object {
        private const val BASE_URL = "https://www.cbssports.com/nfl/scoreboard/2020/regular/1/"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            val document = Jsoup.connect(BASE_URL).get()
            val elements  = document.select("div.in-progress-table.section")
            Log.d("SUSFU", elements[4].select("a.team.helper-team-name").text())
            Log.d("SUSFU", elements[4].select("td.total-score").text())

//            val team = elements.select("a.team.helper-team-name")
//            for (i in elements.size - 1 downTo 0) {
//            Log.d("SUSFU", elements[i].text())
//            }
        }
    }

//    private fun getTeams(elements : Elements) = elements.select()

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
/*
            val connection = Jsoup.connect(BASE_URL).method(Connection.Method.GET)
            val response = connection.execute()
            val html = response.body()

            val file = File(getExternalFilesDir(null), "nlf202001.html")
            try {
                val bufferedWriter = BufferedWriter(FileWriter(file))
                bufferedWriter.write(html)
                bufferedWriter.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
*/
