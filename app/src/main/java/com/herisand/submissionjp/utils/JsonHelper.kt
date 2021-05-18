package com.herisand.submissionjp.utils

import android.content.Context
import com.herisand.submissionjp.datafile.source.local.entity.MovieData
import com.herisand.submissionjp.datafile.source.local.entity.TvData
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper (private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val bufffer = ByteArray(`is`.available())
            `is`.read(bufffer)
            `is`.close()
            String(bufffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovie(): List<MovieData> {
        val list = ArrayList<MovieData>()
        try {
            val responseObject = JSONObject(parsingFileToString("movie.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val id = movie.getInt("id")
                val title = movie.getString("title")
                val image = movie.getString("poster_path")
                val description = movie.getString("overview")
                val score = movie.getDouble("vote_average")
                val year = movie.getString("release_date")
                val background = movie.getString("backdrop_path")

                val movieData = MovieData(id, title, image, description, score, year, background)
                list.add(movieData)
            }
        } catch (e:JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadTvShow(): List<TvData> {
        val list = ArrayList<TvData>()
        try {
            val responseObject = JSONObject(parsingFileToString("tv.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()) {
                val tvShow = listArray.getJSONObject(i)

                val id = tvShow.getInt("id")
                val title = tvShow.getString("name")
                val image = tvShow.getString("poster_path")
                val description = tvShow.getString("overview")
                val score = tvShow.getDouble("vote_average")
                val year = tvShow.getString("first_air_date")
                val background = tvShow.getString("backdrop_path")

                val tvData = TvData(id, title, image, description, score,year, background)
                list.add(tvData)
            }
        } catch (e:JSONException) {
            e.printStackTrace()
        }
        return list
    }


}