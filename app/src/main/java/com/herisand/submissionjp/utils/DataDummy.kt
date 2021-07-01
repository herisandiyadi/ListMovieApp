package com.herisand.submissionjp.utils

import androidx.paging.PagedList
import com.herisand.submissionjp.datafile.source.local.entity.DetailData
import com.herisand.submissionjp.datafile.source.local.entity.MovieEntity
import com.herisand.submissionjp.datafile.source.local.entity.TvEntity
import com.herisand.submissionjp.datafile.source.remote.response.movie.MovieRemote
import com.herisand.submissionjp.datafile.source.remote.response.tvshow.TVShowRemote
import com.herisand.submissionjp.resources.Resource

object DataDummy {

    fun generateDataTv(): List<TvEntity> {
        val tvshow = ArrayList<TvEntity>()

        tvshow.add(
            TvEntity(88396,"The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                7.9,
                "2017-09-25",
                "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg")
        )
        tvshow.add(
            TvEntity(2012,"Doom Patrol",
                "/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                7.6,
                "2019",
                "Sci-Fi & Fantasy, Action & Adventure, Comedy"
            )
        )
        tvshow.add(
            TvEntity(2013,"Dragon Ball",
                "/f2zhRLqwRLrKhEMeIM7Z5buJFo3.jpg",
                "Five years have passed since the fight with Piccolo Jr., and Goku now has a son, Gohan. The peace is interrupted when an alien named Raditz arrives on Earth in a spacecraft and tracks down Goku, revealing to him that that they are members of a near-extinct warrior race called the Saiyans.",
                8.2,
                "1989",
                "Animation, Sci-Fi & Fantasy, Action & Adventure"
            )
        )
        tvshow.add(
            TvEntity(2014,"Fairy Tail",
                "/jsYTctFnK8ewomnUgcwhmsTkOum.jpg",
                "Natsu Dragneel and his friends travel to the island Kingdom of Stella, where they will reveal dark secrets, fight the new enemies and once again save the world from destruction.",
                6.5,
                "2017",
                "Action, Adventure, Comedy, Fantasy, Animation"
            )
        )
        tvshow.add(
            TvEntity(2015,"Family Guy",
                "/eWWCRjBfLyePh2tfZdvNcIvKSJe.jpg",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                6.9,
                "1999",
                "Animation Comedy"
            )
        )
        return tvshow
    }

    fun generateRemoteDataTv(): List<TVShowRemote> {
        val tvshow = ArrayList<TVShowRemote>()

        tvshow.add(
            TVShowRemote(88396,"The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                7.9,
                "2017-09-25",
                "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
            false)
        )
        tvshow.add(
            TVShowRemote(2012,"Doom Patrol",
                "/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                7.6,
                "2019",
                "Sci-Fi & Fantasy, Action & Adventure, Comedy",
                false
            )
        )
        tvshow.add(
            TVShowRemote(2013,"Dragon Ball",
                "/f2zhRLqwRLrKhEMeIM7Z5buJFo3.jpg",
                "Five years have passed since the fight with Piccolo Jr., and Goku now has a son, Gohan. The peace is interrupted when an alien named Raditz arrives on Earth in a spacecraft and tracks down Goku, revealing to him that that they are members of a near-extinct warrior race called the Saiyans.",
                8.2,
                "1989",
                "Animation, Sci-Fi & Fantasy, Action & Adventure",
                false
            )
        )
        tvshow.add(
            TVShowRemote(2014,"Fairy Tail",
                "/jsYTctFnK8ewomnUgcwhmsTkOum.jpg",
                "Natsu Dragneel and his friends travel to the island Kingdom of Stella, where they will reveal dark secrets, fight the new enemies and once again save the world from destruction.",
                6.5,
                "2017",
                "Action, Adventure, Comedy, Fantasy, Animation",
                false
            )
        )
        tvshow.add(
            TVShowRemote(2015,"Family Guy",
                "/eWWCRjBfLyePh2tfZdvNcIvKSJe.jpg",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                6.9,
                "1999",
                "Animation Comedy",
                false
            )
        )


        return tvshow
    }

    fun getDetailMovie(): DetailData {
        return DetailData(
            567189, "Tom Clancy's Without Remorse",
            "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
            "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
            7.3,
            "2021-04-29",
            "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
            false
        )
    }

    fun getDetailTV(): DetailData {
        return DetailData(
            88396,"The Falcon and the Winter Soldier",
            "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
            "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
            7.9,
            "2017-09-25",
            "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
            false

        )
    }

    fun generateDataMovie(): ArrayList<MovieEntity> {
        val movie = ArrayList<MovieEntity>()

        movie.add(
            MovieEntity(567189, "Tom Clancy's Without Remorse",
                "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                7.3,
                "2021-04-29",
                "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg"
            )
        )

        movie.add(
            MovieEntity(460465, "Mortal Kombat",
                "/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                7.8,
                "2021-04-07",
                "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg"
            )
        )
        movie.add(
            MovieEntity(3022,"Alita: Battle Angel",
                "/xRWht48C2V8XNfzvPehyClOvDni.jpg",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                7.2,
                "2019",
                "Action, Adventure, Sci-Fi"
            )
        )
        movie.add(
            MovieEntity(3023,"Aquaman",
                "/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                7.2,
                "2019",
                "/8RKBHHRqOMOLh5qW3sS6TSFTd8h.jpg"
            )
        )
        movie.add(
            MovieEntity(3024,"Bohemian Rhapsody",
                "/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                8.0,
                "2018",
                "Music, Drama, History"
            )
        )
       return movie
    }

    fun generateRemoteDataMovie(): List<MovieRemote> {
        val movie = ArrayList<MovieRemote>()

        movie.add(
            MovieRemote(567189, "Tom Clancy's Without Remorse",
                "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                7.3,
                "2021-04-29",
                "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                false
            )
        )

        movie.add(
            MovieRemote(460465, "Mortal Kombat",
                "/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                7.8,
                "2021-04-07",
                "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
                false
            )
        )
        movie.add(
            MovieRemote(3022,"Alita: Battle Angel",
                "/xRWht48C2V8XNfzvPehyClOvDni.jpg",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                7.2,
                "2019",
                "Action, Adventure, Sci-Fi",
                false
            )
        )
        movie.add(
            MovieRemote(3023,"Aquaman",
                "/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                7.2,
                "2019",
                "/8RKBHHRqOMOLh5qW3sS6TSFTd8h.jpg",
                false
            )
        )
        movie.add(
            MovieRemote(3024,"Bohemian Rhapsody",
                "/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                8.0,
                "2018",
                "Music, Drama, History",
                false
            )
        )
        return movie
    }

}