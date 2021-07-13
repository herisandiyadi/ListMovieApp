package com.herisand.submissionjp.utils

import com.herisand.submissionjp.datafile.source.local.entity.MovieEntity
import com.herisand.submissionjp.datafile.source.local.entity.TvEntity

object DetailDataDummy {

    fun getDetailMovie(): MovieEntity {
        return MovieEntity(
            567189, "Tom Clancy's Without Remorse",
            "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
            "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
            7.3,
            "2021-04-29",
            "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
            false
        )
    }

    fun getDetailTVShow(): TvEntity {
        return TvEntity(
            88396,"The Falcon and the Winter Soldier",
            "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
            "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
            7.9,
            "2017-09-25",
            "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
            false
        )
    }

}