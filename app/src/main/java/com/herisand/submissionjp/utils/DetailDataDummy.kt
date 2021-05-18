package com.herisand.submissionjp.utils

import com.herisand.submissionjp.datafile.source.local.entity.DetailData
import com.herisand.submissionjp.datafile.source.remote.response.GenreResponse
import com.herisand.submissionjp.datafile.source.remote.response.movie.MoviesDetailResponse
import com.herisand.submissionjp.datafile.source.remote.response.tvshow.TVShowsDetailResponse

object DetailDataDummy {

    fun getDetailMovie(): DetailData {
        return DetailData(
            567189, "Tom Clancy's Without Remorse",
            "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
            "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
            7.3,
            "2021-04-29",
            "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
            listOf("Action", "Adventure", "Thriller", "War")
        )
    }

    fun getDetailTVShow(): DetailData {
        return DetailData(
            88396,"The Falcon and the Winter Soldier",
            "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
            "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
            7.9,
            "2017-09-25",
            "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
            listOf("Sci-Fi & Fantasy, Action & Adventure, Comedy")
        )
    }


    fun getRemoteDetailMovie(): MoviesDetailResponse {
        return MoviesDetailResponse(
            567189, "Tom Clancy's Without Remorse",
            "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
            "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
            7.3,
            "2021-04-29",
            "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
            listOf(
                GenreResponse(28, "Action"),
                GenreResponse(12, "Adventure"),
                GenreResponse(53, "Thriller"),
                GenreResponse(10752, "War")
            )
        )
    }

    fun getRemoteDetailTVShow(): TVShowsDetailResponse {
        return TVShowsDetailResponse(
            88396,"The Falcon and the Winter Soldier",
            "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
            "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
            7.9,
            "2017-09-25",
            "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",

            listOf(
                GenreResponse(10765, "Sci-Fi & Fantasy"),
                GenreResponse(10759,"Sci-Fi & Fantasy"),
                GenreResponse(18, "Action & Adventure"),
                GenreResponse(10768, "Comedy")
            )
        )
    }
}