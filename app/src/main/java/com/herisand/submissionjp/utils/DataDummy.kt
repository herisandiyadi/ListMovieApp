package com.herisand.submissionjp.utils

import com.herisand.submissionjp.datafile.source.local.entity.DetailData
import com.herisand.submissionjp.datafile.source.local.entity.MovieData
import com.herisand.submissionjp.datafile.source.local.entity.TvData
import com.herisand.submissionjp.datafile.source.remote.response.movie.MovieRemote
import com.herisand.submissionjp.datafile.source.remote.response.tvshow.TVShowRemote

object DataDummy {

    fun generateDataTv(): List<TvData> {
        val tvshow = ArrayList<TvData>()

        tvshow.add(
            TvData(88396,"The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                7.9,
                "2017-09-25",
                "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg")
        )
        tvshow.add(
            TvData(2012,"Doom Patrol",
                "/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                7.6,
                "2019",
                "Sci-Fi & Fantasy, Action & Adventure, Comedy"
            )
        )
        tvshow.add(
            TvData(2013,"Dragon Ball",
                "/f2zhRLqwRLrKhEMeIM7Z5buJFo3.jpg",
                "Five years have passed since the fight with Piccolo Jr., and Goku now has a son, Gohan. The peace is interrupted when an alien named Raditz arrives on Earth in a spacecraft and tracks down Goku, revealing to him that that they are members of a near-extinct warrior race called the Saiyans.",
                8.2,
                "1989",
                "Animation, Sci-Fi & Fantasy, Action & Adventure"
            )
        )
        tvshow.add(
            TvData(2014,"Fairy Tail",
                "/jsYTctFnK8ewomnUgcwhmsTkOum.jpg",
                "Natsu Dragneel and his friends travel to the island Kingdom of Stella, where they will reveal dark secrets, fight the new enemies and once again save the world from destruction.",
                6.5,
                "2017",
                "Action, Adventure, Comedy, Fantasy, Animation"
            )
        )
        tvshow.add(
            TvData(2015,"Family Guy",
                "/eWWCRjBfLyePh2tfZdvNcIvKSJe.jpg",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                6.9,
                "1999",
                "Animation Comedy"
            )
        )
        tvshow.add(
            TvData(2016,"Flash",
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                7.6,
                "2014",
                "Drama, Sci-Fi & Fantasy"
            )
        )
        tvshow.add(
            TvData(2017,"Got",
                "/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                8.4,
                "2011",
                "Sci-Fi & Fantasy, Drama, Action & Adventure"
            )
        )
        tvshow.add(
            TvData(2018,"Gotham",
                "/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                7.5,
                "2014",
                "Drama, Crime, Sci-Fi & Fantasy"
            )
        )
        tvshow.add(
            TvData(2019,"Grey's Anatomy",
                "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                8.2,
                "2005",
                "Drama"
            )
        )
        tvshow.add(
            TvData(2020,"Hanna",
                "/iYUtjx1EN4SVTgxd2TB4cZTGSQb.jpg",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                7.5,
                "2019",
                "Action & Adventure, Drama")
        )
        tvshow.add(
            TvData(2021,"Iron Fist",
                "/4l6KD9HhtD6nCDEfg10Lp6C6zah.jpg",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                6.5,
                "2017",
                "Action & Adventure, Drama, Sci-Fi & Fantasy"
            )
        )
        tvshow.add(
            TvData(2022,"Naruto Shipudden",
                "/hKkY4Hf5tDKCwVzzeo42vp1RxPQ.jpg",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                8.6,
                "2007",
                "Animation, Action & Adventure, Sci-Fi & Fantasy"
            )
        )
        tvshow.add(
            TvData(2023,"NCIS",
                "/fi8EvaWtL5CvoielOjjVvTr7ux3.jpg",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                7.3,
                "2003",
                "Crime, Action & Adventure, Drama"
            )
        )
        tvshow.add(
            TvData(2024,"Riverdale",
                "/5s9XHTB9SLPdg3mNU6BlSLnZ9Qq.jpg",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                8.6,
                "2017",
                "Mystery, Drama, Crime"
            )
        )
        tvshow.add(
            TvData(2025,"Shameless",
                "/9akij7PqZ1g6zl42DQQTtL9CTSb.jpg",
                "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
                7.9,
                "2011",
                "Drama, Comedy"
            )
        )
        tvshow.add(
            TvData(2026,"Supergirl",
                "/4ka8vAzAFUZFKxWyfGfwVcSXuZo.jpg",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                7.2,
                "2015",
                "Drama, Sci-Fi & Fantasy, Action & Adventure"
            )
        )
        tvshow.add(
            TvData(2027,"Supernatural",
                "/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
                8.2,
                "2005",
                "Drama, Mystery, Sci-Fi & Fantasy"
            )
        )
        tvshow.add(
            TvData(2028,"The Simpson",
                "/2IWouZK4gkgHhJa3oyYuSWfSqbG.jpg",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                7.8,
                "1989",
                "Family, Animation, Comedy"
            )
        )
        tvshow.add(
            TvData(2029,"The Umbrella Academy",
                "/scZlQQYnDVlnpxFTxaIv2g0BWnL.jpg",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                8.7,
                "2019",
                "Action & Adventure, Sci-Fi & Fantasy, Drama"
            )
        )
        tvshow.add(
            TvData(2030,"The Walking Dead",
                "/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                8.0,
                "2010",
                "Action & Adventure, Drama, Sci-Fi & Fantasy"
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
                "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg")
        )
        tvshow.add(
            TVShowRemote(2012,"Doom Patrol",
                "/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                7.6,
                "2019",
                "Sci-Fi & Fantasy, Action & Adventure, Comedy"
            )
        )
        tvshow.add(
            TVShowRemote(2013,"Dragon Ball",
                "/f2zhRLqwRLrKhEMeIM7Z5buJFo3.jpg",
                "Five years have passed since the fight with Piccolo Jr., and Goku now has a son, Gohan. The peace is interrupted when an alien named Raditz arrives on Earth in a spacecraft and tracks down Goku, revealing to him that that they are members of a near-extinct warrior race called the Saiyans.",
                8.2,
                "1989",
                "Animation, Sci-Fi & Fantasy, Action & Adventure"
            )
        )
        tvshow.add(
            TVShowRemote(2014,"Fairy Tail",
                "/jsYTctFnK8ewomnUgcwhmsTkOum.jpg",
                "Natsu Dragneel and his friends travel to the island Kingdom of Stella, where they will reveal dark secrets, fight the new enemies and once again save the world from destruction.",
                6.5,
                "2017",
                "Action, Adventure, Comedy, Fantasy, Animation"
            )
        )
        tvshow.add(
            TVShowRemote(2015,"Family Guy",
                "/eWWCRjBfLyePh2tfZdvNcIvKSJe.jpg",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                6.9,
                "1999",
                "Animation Comedy"
            )
        )
        tvshow.add(
            TVShowRemote(2016,"Flash",
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                7.6,
                "2014",
                "Drama, Sci-Fi & Fantasy"
            )
        )
        tvshow.add(
            TVShowRemote(2017,"Got",
                "/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                8.4,
                "2011",
                "Sci-Fi & Fantasy, Drama, Action & Adventure"
            )
        )
        tvshow.add(
            TVShowRemote(2018,"Gotham",
                "/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                7.5,
                "2014",
                "Drama, Crime, Sci-Fi & Fantasy"
            )
        )
        tvshow.add(
            TVShowRemote(2019,"Grey's Anatomy",
                "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                8.2,
                "2005",
                "Drama"
            )
        )
        tvshow.add(
            TVShowRemote(2020,"Hanna",
                "/iYUtjx1EN4SVTgxd2TB4cZTGSQb.jpg",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                7.5,
                "2019",
                "Action & Adventure, Drama")
        )
        tvshow.add(
            TVShowRemote(2021,"Iron Fist",
                "/4l6KD9HhtD6nCDEfg10Lp6C6zah.jpg",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                6.5,
                "2017",
                "Action & Adventure, Drama, Sci-Fi & Fantasy"
            )
        )
        tvshow.add(
            TVShowRemote(2022,"Naruto Shipudden",
                "/hKkY4Hf5tDKCwVzzeo42vp1RxPQ.jpg",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                8.6,
                "2007",
                "Animation, Action & Adventure, Sci-Fi & Fantasy"
            )
        )
        tvshow.add(
            TVShowRemote(2023,"NCIS",
                "/fi8EvaWtL5CvoielOjjVvTr7ux3.jpg",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                7.3,
                "2003",
                "Crime, Action & Adventure, Drama"
            )
        )
        tvshow.add(
            TVShowRemote(2024,"Riverdale",
                "/5s9XHTB9SLPdg3mNU6BlSLnZ9Qq.jpg",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                8.6,
                "2017",
                "Mystery, Drama, Crime"
            )
        )
        tvshow.add(
            TVShowRemote(2025,"Shameless",
                "/9akij7PqZ1g6zl42DQQTtL9CTSb.jpg",
                "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
                7.9,
                "2011",
                "Drama, Comedy"
            )
        )
        tvshow.add(
            TVShowRemote(2026,"Supergirl",
                "/4ka8vAzAFUZFKxWyfGfwVcSXuZo.jpg",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                7.2,
                "2015",
                "Drama, Sci-Fi & Fantasy, Action & Adventure"
            )
        )
        tvshow.add(
            TVShowRemote(2027,"Supernatural",
                "/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
                8.2,
                "2005",
                "Drama, Mystery, Sci-Fi & Fantasy"
            )
        )
        tvshow.add(
            TVShowRemote(2028,"The Simpson",
                "/2IWouZK4gkgHhJa3oyYuSWfSqbG.jpg",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                7.8,
                "1989",
                "Family, Animation, Comedy"
            )
        )
        tvshow.add(
            TVShowRemote(2029,"The Umbrella Academy",
                "/scZlQQYnDVlnpxFTxaIv2g0BWnL.jpg",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                8.7,
                "2019",
                "Action & Adventure, Sci-Fi & Fantasy, Drama"
            )
        )
        tvshow.add(
            TVShowRemote(2030,"The Walking Dead",
                "/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                8.0,
                "2010",
                "Action & Adventure, Drama, Sci-Fi & Fantasy"
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
            listOf("Action", "Adventure", "Thriller", "War")
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
            listOf("Sci-Fi & Fantasy", "Action & Adventure", "Drama", "War & Politics")

        )
    }

    fun generateDataMovie(): List<MovieData> {
        val movie = ArrayList<MovieData>()

        movie.add(
            MovieData(567189, "Tom Clancy's Without Remorse",
                "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                7.3,
                "2021-04-29",
                "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg"
            )
        )

        movie.add(
            MovieData(460465, "Mortal Kombat",
                "/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                7.8,
                "2021-04-07",
                "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg"
            )
        )
        movie.add(
            MovieData(3022,"Alita: Battle Angel",
                "/xRWht48C2V8XNfzvPehyClOvDni.jpg",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                7.2,
                "2019",
                "Action, Adventure, Sci-Fi"
            )
        )
        movie.add(
            MovieData(3023,"Aquaman",
                "/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                7.2,
                "2019",
                "/8RKBHHRqOMOLh5qW3sS6TSFTd8h.jpg"
            )
        )
        movie.add(
            MovieData(3024,"Bohemian Rhapsody",
                "/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                8.0,
                "2018",
                "Music, Drama, History"
            )
        )
        movie.add(
            MovieData(3025,"Cold Persuit",
                "/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
                "A grieving snowplow driver seeks out revenge against the drug dealers who killed his son.",
                6.2,
                "2018",
                "Action, Crime, Drama"
            )
        )
        movie.add(
            MovieData(3026,"Creed",
                "/iBq4od6j1ZAvDVO7hwmHT2Xf2Bt.jpg",
                "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
                7.4,
                "2015",
                "Drama"
            )
        )
        movie.add(
            MovieData(3027,"The Crimes of The Grindwald",
                "/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                6.9,
                "2018",
                "Adventure, Fantasy, Drama"
            )
        )
        movie.add(
            MovieData(3028,"Glass",
                "/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                6.6,
                "2019",
                "Thriller, Drama, Science Fiction"
            )
        )
        movie.add(
            MovieData(3029,"How to Train The Dragon",
                "/ygGmAO60t8GyqUo9xYeYxSZAR3b.jpg",
                "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father",
                7.8,
                "2010",
                "Fantasy, Adventure, Animation, Family"
            )
        )
        movie.add(
            MovieData(3030,"Avengers Infinity Wars",
                "/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                8.3,
                "2018",
                "Adventure, Action, Science Fiction"
            )
        )
        movie.add(
            MovieData(3031,"Mary Queen of The Scots",
                "/b5RMzLAyq5QW6GtN9sIeAEMLlBI.jpg",
                "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
                6.6,
                "2018",
                "Drama, History"
            )
        )
        movie.add(
            MovieData(3032,"Master Z",
                "/6VxEvOF7QDovsG6ro9OVyjH07LF.jpg",
                "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                5.7,
                "2018",
                "Action"
            )
        )
        movie.add(
            MovieData(3033,"Mortal Engines",
                "/gLhYg9NIvIPKVRTtvzCWnp1qJWG.jpg",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                6.1,
                "2018",
                "Adventure, Science Fiction"
            )
        )
        movie.add(
            MovieData(3034,"Overlord",
                "/l76Rgp32z2UxjULApxGXAPpYdAP.jpg",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
                6.7,
                "2018",
                "Horror, War, Science Fiction"
            )
        )
        movie.add(
            MovieData(3035,"Ralph Break The Internet",
                "/dbvAUZWOepRxwUnSOvZAGsrPjta.jpg",
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
                7.2,
                "2018",
                "Family, Animation, Comedy, Adventure"
            )
        )
        movie.add(
            MovieData(3036,"Robin Hood",
                "/AiRfixFcfTkNbn2A73qVJPlpkUo.jpg",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown",
                5.9,
                "2018",
                "Adventure, Action, Thriller"
            )
        )
        movie.add(
            MovieData(3037,"Serenity",
                "/hgWAcic93phg4DOuQ8NrsgQWiqu.jpg",
                "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help.",
                5.4,
                "2019",
                "Thriller, Mystery, Drama"
            )
        )
        movie.add(
            MovieData(3038,"Spiderman: Into The Spider-Verse",
                "/iiZZdoQBEYBv6id8su7ImL0oCbD.jpg",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                8.4,
                "2018",
                "Action, Adventure, ANimation, ScienceFiction, Comedy"
            )
        )
        movie.add(
            MovieData(3039,"T34",
                "/jqBIHiSglRfNxjh1zodHLa9E7zW.jpg",
                "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
                6.8,
                "2018",
                "War Action, Drama, History"
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
                "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg"
            )
        )

        movie.add(
            MovieRemote(460465, "Mortal Kombat",
                "/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                7.8,
                "2021-04-07",
                "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg"
            )
        )
        movie.add(
            MovieRemote(3022,"Alita: Battle Angel",
                "/xRWht48C2V8XNfzvPehyClOvDni.jpg",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                7.2,
                "2019",
                "Action, Adventure, Sci-Fi"
            )
        )
        movie.add(
            MovieRemote(3023,"Aquaman",
                "/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                7.2,
                "2019",
                "/8RKBHHRqOMOLh5qW3sS6TSFTd8h.jpg"
            )
        )
        movie.add(
            MovieRemote(3024,"Bohemian Rhapsody",
                "/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                8.0,
                "2018",
                "Music, Drama, History"
            )
        )
        movie.add(
            MovieRemote(3025,"Cold Persuit",
                "/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
                "A grieving snowplow driver seeks out revenge against the drug dealers who killed his son.",
                6.2,
                "2018",
                "Action, Crime, Drama"
            )
        )
        movie.add(
            MovieRemote(3026,"Creed",
                "/iBq4od6j1ZAvDVO7hwmHT2Xf2Bt.jpg",
                "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
                7.4,
                "2015",
                "Drama"
            )
        )
        movie.add(
            MovieRemote(3027,"The Crimes of The Grindwald",
                "/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                6.9,
                "2018",
                "Adventure, Fantasy, Drama"
            )
        )
        movie.add(
            MovieRemote(3028,"Glass",
                "/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                6.6,
                "2019",
                "Thriller, Drama, Science Fiction"
            )
        )
        movie.add(
            MovieRemote(3029,"How to Train The Dragon",
                "/ygGmAO60t8GyqUo9xYeYxSZAR3b.jpg",
                "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father",
                7.8,
                "2010",
                "Fantasy, Adventure, Animation, Family"
            )
        )
        movie.add(
            MovieRemote(3030,"Avengers Infinity Wars",
                "/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                8.3,
                "2018",
                "Adventure, Action, Science Fiction"
            )
        )
        movie.add(
            MovieRemote(3031,"Mary Queen of The Scots",
                "/b5RMzLAyq5QW6GtN9sIeAEMLlBI.jpg",
                "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
                6.6,
                "2018",
                "Drama, History"
            )
        )
        movie.add(
            MovieRemote(3032,"Master Z",
                "/6VxEvOF7QDovsG6ro9OVyjH07LF.jpg",
                "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                5.7,
                "2018",
                "Action"
            )
        )
        movie.add(
            MovieRemote(3033,"Mortal Engines",
                "/gLhYg9NIvIPKVRTtvzCWnp1qJWG.jpg",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                6.1,
                "2018",
                "Adventure, Science Fiction"
            )
        )
        movie.add(
            MovieRemote(3034,"Overlord",
                "/l76Rgp32z2UxjULApxGXAPpYdAP.jpg",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
                6.7,
                "2018",
                "Horror, War, Science Fiction"
            )
        )
        movie.add(
            MovieRemote(3035,"Ralph Break The Internet",
                "/dbvAUZWOepRxwUnSOvZAGsrPjta.jpg",
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
                7.2,
                "2018",
                "Family, Animation, Comedy, Adventure"
            )
        )
        movie.add(
            MovieRemote(3036,"Robin Hood",
                "/AiRfixFcfTkNbn2A73qVJPlpkUo.jpg",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown",
                5.9,
                "2018",
                "Adventure, Action, Thriller"
            )
        )
        movie.add(
            MovieRemote(3037,"Serenity",
                "/hgWAcic93phg4DOuQ8NrsgQWiqu.jpg",
                "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help.",
                5.4,
                "2019",
                "Thriller, Mystery, Drama"
            )
        )
        movie.add(
            MovieRemote(3038,"Spiderman: Into The Spider-Verse",
                "/iiZZdoQBEYBv6id8su7ImL0oCbD.jpg",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                8.4,
                "2018",
                "Action, Adventure, ANimation, ScienceFiction, Comedy"
            )
        )
        movie.add(
            MovieRemote(3039,"T34",
                "/jqBIHiSglRfNxjh1zodHLa9E7zW.jpg",
                "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
                6.8,
                "2018",
                "War Action, Drama, History"
            )
        )
        return movie
    }



}