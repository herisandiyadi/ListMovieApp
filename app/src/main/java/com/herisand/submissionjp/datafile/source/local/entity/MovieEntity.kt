package com.herisand.submissionjp.datafile.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.herisand.submissionjp.datafile.source.remote.response.GenreResponse

@Entity(tableName= "movieentity" )
data class MovieEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "id")
        var id: Int,

        @ColumnInfo(name = "title")
        var title: String,

        @ColumnInfo(name = "image")
        var image: String,

        @ColumnInfo(name = "descriptions")
        var description: String,

        @ColumnInfo(name = "scores")
        var scores: Double,

        @ColumnInfo(name = "date")
        var date: String,

        @ColumnInfo(name = "background")
        var background: String,

        @ColumnInfo(name = "favorite")
        var favorite: Boolean = false

)
