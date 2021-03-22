package com.mov.moviecatalogue.utils

import com.mov.moviecatalogue.data.model.MovieEntity
import com.mov.moviecatalogue.data.model.TvShowEntity

object DataDummy {
    fun generateDummyMovie(): List<MovieEntity> {

        val movie = ArrayList<MovieEntity>()

        movie.add(
            MovieEntity(14,
            "Tom & Jerry (2021)",
            "Tom the cat and Jerry the mouse get kicked out of their home and relocate to a fancy New York hotel, where a scrappy employee named Kayla will lose her job if she can’t evict Jerry before a high-class wedding at the hotel. Her solution? Hiring Tom to get rid of the pesky mouse.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/yMoMlJo2msoVwmuf6k1C78MrB3H.jpg",

                "Action, Comedy, Family, Animation, Adventure",
                0.1F,
                "","","")
        )
        movie.add(
            MovieEntity(15,
            "Monster Hunter (2020)",
            "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
                "Fantasy, Action, Adventure ",
                0.1F,
                "","","")
        )
        movie.add(
            MovieEntity(16,
            "Red Dot (2021)",
            "On a hiking trip to rekindle their marriage, a couple find themselves fleeing for their lives in the unforgiving wilderness from an unknown shooter.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xZ2KER2gOHbuHP2GJoODuXDSZCb.jpg",

                "Drama, Thriller",
                0.1F,
                "","","")
        )
        movie.add(
            MovieEntity(17,
            "Space Sweepers (2021)",
            "When the crew of a space junk collector ship called The Victory discovers a humanoid robot named Dorothy that's known to be a weapon of mass destruction, they get involved in a risky business deal which puts their lives at stake.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/y2Yp7KC2FJSsdlRM5qkkIwQGCqU.jpg",
                "Drama, Fantasy, Science Fiction",
                0.1F,
                "","","")
        )
        movie.add(
            MovieEntity(18,
            "Wonder Woman 1984 (2020)",
            "Wonder Woman comes into conflict with the Soviet Union during the Cold War in the 1980s and finds a formidable foe by the name of the Cheetah.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
                "Fantasy, Action, Adventure",
                0.1F,
                "","","")
        )
        movie.add(
            MovieEntity(19,
            "Raya and the Last Dragon (2021)",
            "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",

                "Animation, Adventure, Fantasy, Family",
                0.1F,
                "","","")
        )
        movie.add(
            MovieEntity(20,
            "Outside the Wire (2021)",
            "In the near future, a drone pilot is sent into a deadly militarized zone and must work with an android officer to locate a doomsday device.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6XYLiMxHAaCsoyrVo38LBWMw2p8.jpg",

                "Thriller, Action, Science Fiction",
                0.1F,
                "","","")
        )
        movie.add(
            MovieEntity(21,
            "Below Zero (2021)",
            "When a prisoner transfer van is attacked, the cop in charge must fight those inside and outside while dealing with a silent foe: the icy temperatures.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/dWSnsAGTfc8U27bWsy2RfwZs0Bs.jpg",
                "Action, Crime, Thriller",
                0.1F,
                "","","")
        )
        movie.add(
            MovieEntity(21,
            "The Little Things (2021)",
            "Deputy Sheriff Joe \"Deke\" Deacon joins forces with Sgt. Jim Baxter to search for a serial killer who's terrorizing Los Angeles. As they track the culprit, Baxter is unaware that the investigation is dredging up echoes of Deke's past, uncovering disturbing secrets that could threaten more than his case.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/c7VlGCCgM9GZivKSzBgzuOVxQn7.jpg",
                "Thriller, Crime",
                0.1F,
                "","","")
        )
        movie.add(
            MovieEntity(22,
            "Breach (2020)",
            "A hardened mechanic must stay awake and maintain an interstellar ark fleeing the dying planet Earth with a few thousand lucky souls on board... the last of humanity. Unfortunately, humans are not the only passengers. A shapeshifting alien creature has taken residence, its only goal is to kill as many people as possible. The crew must think quickly to stop this menace before it destroys mankind.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/13B6onhL6FzSN2KaNeQeMML05pS.jpg",
                "Science Fiction, Action",
                0.1F,
                "","","")
        )

        return movie
    }

    fun generateDummyTvShow(): List<TvShowEntity> {

        val tvshow = ArrayList<TvShowEntity>()

        tvshow.add(
            TvShowEntity(1,
                "WandaVision (2021)",
                "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/glKDfE6btIRcVB5zrjspRIs4r52.jpg",
                "Sci-Fi & Fantasy, Mystery, Drama",
                0.1F,
                "")
        )
        tvshow.add(
            TvShowEntity(2,
                "The Flash (2014)",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "Drama, Sci-Fi & Fantasy",
                0.1F,
                "")
        )
        tvshow.add(
            TvShowEntity(3,
                "Riverdale (2017)",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                "Mystery, Drama, Crime",
                0.1F,
                "")
        )
        tvshow.add(
            TvShowEntity(4,
                "Superman & Lois (2021)",
                "After years of facing megalomaniacal supervillains, monsters wreaking havoc on Metropolis, and alien invaders intent on wiping out the human race, The Man of Steel aka Clark Kent and Lois Lane come face to face with one of their greatest challenges ever: dealing with all the stress, pressures and complexities that come with being working parents in today's society.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6SJppowm7cdQgLkvoTlnTUSbjr9.jpg",
                "Action & Adventure, Sci-Fi & Fantasy",
                0.1F,
                "")
        )
        tvshow.add(
            TvShowEntity(5,
                "The Walking Dead (2010)",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                0.1F,
                "")
        )
        tvshow.add(
            TvShowEntity(6,
                "Dos vidas (2021)",
                "The story of Julia, a woman currently living out the life that her mother and future husband have planned for her. But just as she is about to get married, she discovers a great family secret that will change her forever. On the verge of a nervous breakdown, she decides to get away and finds refuge in a secluded town in the mountains of Madrid where she will have a complicated mission: to take control of her own destiny.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gr4mvVThwX2lXajmScgzLKYcccS.jpg",
                "-",
                0.1F,
                "")
        )
        tvshow.add(
            TvShowEntity(7,
                "Are You Afraid of the Dark? (2019)",
                "Each season of this horror anthology series follows a different group of kids, members of the Midnight Society, as they discover terrifying curses and creatures.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/seCdnVx50nhHmDqaC6QEYM3jSG3.jpg",
                "Mystery",
                0.1F,
                "")
        )
        tvshow.add(
            TvShowEntity(8,
                "The Boarding School: Las Cumbres (2021)",
                "In an inaccessible place between the mountains and isolated from the world, a school is located next to an old monastery. The students are rebellious and problematic young people who live under the strict and severe discipline imposed by the center to reintegrate them into society. The surrounding forest is home to ancient legends, threats that are still valid and that will immerse them in terrifying adventures.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gqKKNHqmkb8LDYJgoVKqOTiCn64.jpg",
                "Drama, Mystery",
                0.1F,
                "")
        )
        tvshow.add(
            TvShowEntity(9,
                "The Good Doctor (2017)",

                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "His mind is a mystery, his methods are a miracle.",
                0.1F,
                "")
        )
        tvshow.add(
            TvShowEntity(10,
                "Lucifer (2016)",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "Crime, Sci-Fi & Fantasy",
                0.1F,
            "")
        )
        return tvshow
    }

    fun generateRemoteDummyMovies():List<MovieEntity>{
        val movies = ArrayList<MovieEntity>()
        movies.add(
                MovieEntity(14,
                        "Tom & Jerry (2021)",
                        "Tom the cat and Jerry the mouse get kicked out of their home and relocate to a fancy New York hotel, where a scrappy employee named Kayla will lose her job if she can’t evict Jerry before a high-class wedding at the hotel. Her solution? Hiring Tom to get rid of the pesky mouse.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/yMoMlJo2msoVwmuf6k1C78MrB3H.jpg",

                        "Action, Comedy, Family, Animation, Adventure",
                        0.1F,
                        "","","")
        )
        movies.add(
                MovieEntity(15,
                        "Monster Hunter (2020)",
                        "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
                        "Fantasy, Action, Adventure ",
                        0.1F,
                        "","","")
        )
        movies.add(
                MovieEntity(16,
                        "Red Dot (2021)",
                        "On a hiking trip to rekindle their marriage, a couple find themselves fleeing for their lives in the unforgiving wilderness from an unknown shooter.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xZ2KER2gOHbuHP2GJoODuXDSZCb.jpg",

                        "Drama, Thriller",
                        0.1F,
                        "","","")
        )
        movies.add(
                MovieEntity(17,
                        "Space Sweepers (2021)",
                        "When the crew of a space junk collector ship called The Victory discovers a humanoid robot named Dorothy that's known to be a weapon of mass destruction, they get involved in a risky business deal which puts their lives at stake.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/y2Yp7KC2FJSsdlRM5qkkIwQGCqU.jpg",
                        "Drama, Fantasy, Science Fiction",
                        0.1F,
                        "","","")
        )
        movies.add(
                MovieEntity(18,
                        "Wonder Woman 1984 (2020)",
                        "Wonder Woman comes into conflict with the Soviet Union during the Cold War in the 1980s and finds a formidable foe by the name of the Cheetah.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
                        "Fantasy, Action, Adventure",
                        0.1F,
                        "","","")
        )
        movies.add(
                MovieEntity(19,
                        "Raya and the Last Dragon (2021)",
                        "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",

                        "Animation, Adventure, Fantasy, Family",
                        0.1F,
                        "","","")
        )
        movies.add(
                MovieEntity(20,
                        "Outside the Wire (2021)",
                        "In the near future, a drone pilot is sent into a deadly militarized zone and must work with an android officer to locate a doomsday device.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6XYLiMxHAaCsoyrVo38LBWMw2p8.jpg",

                        "Thriller, Action, Science Fiction",
                        0.1F,
                        "","","")
        )
        movies.add(
                MovieEntity(21,
                        "Below Zero (2021)",
                        "When a prisoner transfer van is attacked, the cop in charge must fight those inside and outside while dealing with a silent foe: the icy temperatures.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/dWSnsAGTfc8U27bWsy2RfwZs0Bs.jpg",
                        "Action, Crime, Thriller",
                        0.1F,
                        "","","")
        )
        movies.add(
                MovieEntity(21,
                        "The Little Things (2021)",
                        "Deputy Sheriff Joe \"Deke\" Deacon joins forces with Sgt. Jim Baxter to search for a serial killer who's terrorizing Los Angeles. As they track the culprit, Baxter is unaware that the investigation is dredging up echoes of Deke's past, uncovering disturbing secrets that could threaten more than his case.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/c7VlGCCgM9GZivKSzBgzuOVxQn7.jpg",
                        "Thriller, Crime",
                        0.1F,
                        "","","")
        )
        movies.add(
                MovieEntity(22,
                        "Breach (2020)",
                        "A hardened mechanic must stay awake and maintain an interstellar ark fleeing the dying planet Earth with a few thousand lucky souls on board... the last of humanity. Unfortunately, humans are not the only passengers. A shapeshifting alien creature has taken residence, its only goal is to kill as many people as possible. The crew must think quickly to stop this menace before it destroys mankind.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/13B6onhL6FzSN2KaNeQeMML05pS.jpg",
                        "Science Fiction, Action",
                        0.1F,
                        "","","")
        )
        return movies
    }
    fun generateRemoteDummyTvShow():List<TvShowEntity>{
        val tvshows = ArrayList<TvShowEntity>()
        tvshows.add(
                TvShowEntity(1,
                        "WandaVision (2021)",
                        "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/glKDfE6btIRcVB5zrjspRIs4r52.jpg",
                        "Sci-Fi & Fantasy, Mystery, Drama",
                        0.1F,
                        "")
        )
        tvshows.add(
                TvShowEntity(2,
                        "The Flash (2014)",
                        "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                        "Drama, Sci-Fi & Fantasy",
                        0.1F,
                        "")
        )
        tvshows.add(
                TvShowEntity(3,
                        "Riverdale (2017)",
                        "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                        "Mystery, Drama, Crime",
                        0.1F,
                        "")
        )
        tvshows.add(
                TvShowEntity(4,
                        "Superman & Lois (2021)",
                        "After years of facing megalomaniacal supervillains, monsters wreaking havoc on Metropolis, and alien invaders intent on wiping out the human race, The Man of Steel aka Clark Kent and Lois Lane come face to face with one of their greatest challenges ever: dealing with all the stress, pressures and complexities that come with being working parents in today's society.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6SJppowm7cdQgLkvoTlnTUSbjr9.jpg",
                        "Action & Adventure, Sci-Fi & Fantasy",
                        0.1F,
                        "")
        )
        tvshows.add(
                TvShowEntity(5,
                        "The Walking Dead (2010)",
                        "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
                        "Action & Adventure, Drama, Sci-Fi & Fantasy",
                        0.1F,
                        "")
        )
        tvshows.add(
                TvShowEntity(6,
                        "Dos vidas (2021)",
                        "The story of Julia, a woman currently living out the life that her mother and future husband have planned for her. But just as she is about to get married, she discovers a great family secret that will change her forever. On the verge of a nervous breakdown, she decides to get away and finds refuge in a secluded town in the mountains of Madrid where she will have a complicated mission: to take control of her own destiny.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gr4mvVThwX2lXajmScgzLKYcccS.jpg",
                        "-",
                        0.1F,
                        "")
        )
        tvshows.add(
                TvShowEntity(7,
                        "Are You Afraid of the Dark? (2019)",
                        "Each season of this horror anthology series follows a different group of kids, members of the Midnight Society, as they discover terrifying curses and creatures.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/seCdnVx50nhHmDqaC6QEYM3jSG3.jpg",
                        "Mystery",
                        0.1F,
                        "")
        )
        tvshows.add(
                TvShowEntity(8,
                        "The Boarding School: Las Cumbres (2021)",
                        "In an inaccessible place between the mountains and isolated from the world, a school is located next to an old monastery. The students are rebellious and problematic young people who live under the strict and severe discipline imposed by the center to reintegrate them into society. The surrounding forest is home to ancient legends, threats that are still valid and that will immerse them in terrifying adventures.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gqKKNHqmkb8LDYJgoVKqOTiCn64.jpg",
                        "Drama, Mystery",
                        0.1F,
                        "")
        )
        tvshows.add(
                TvShowEntity(9,
                        "The Good Doctor (2017)",

                        "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                        "His mind is a mystery, his methods are a miracle.",
                        0.1F,
                        "")
        )
        tvshows.add(
                TvShowEntity(10,
                        "Lucifer (2016)",
                        "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                        "Crime, Sci-Fi & Fantasy",
                        0.1F,
                        "")
        )
        return tvshows
    }
}