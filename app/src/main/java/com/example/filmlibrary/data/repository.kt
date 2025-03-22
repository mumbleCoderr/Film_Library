package com.example.filmlibrary.data


import java.time.LocalDate
import java.util.Date

enum class Genre {
    DRAMA, COMEDY, ACTION, THRILLER, HORROR, DOCUMENTARY
}

open class Production(
    title: String,
    genre: Genre,
    releaseDate: LocalDate,
    var isWatched: Boolean = false,
    comment: String? = null,
    rate: Int? = null,
){
    var title: String = title
        private set

    var genre: Genre = genre
        private set

    var releaseDate: LocalDate = releaseDate
        private set

    var comment: String? = comment
        set(value){
            if(value.isNullOrBlank())
                throw IllegalArgumentException("can't set empty comment")
            field = value
        }
    var rate: Int? = rate
        set(value){
            if (value !in 1..10 || value == null)
                throw IllegalArgumentException("rate has to be in 1..10")
        }

    override fun toString(): String {
        return """
                        Production: ${this.javaClass.simpleName}
                        title: $title
                        genre: $genre
                        release date: $releaseDate
                        is watched?: $isWatched
                        comment: $comment
                        rate: $rate
        """.trimIndent()
    }


}

class Movie(
    title: String,
    genre: Genre,
    releaseDate: LocalDate,
    isWatched: Boolean = false,
    comment: String? = null,
    rate: Int? = null,
    val durationInMinutes: Int
) : Production(title, genre, releaseDate, isWatched, comment, rate){
    override fun toString(): String {
        return super.toString() +
                "duration: ${durationInMinutes/60} ${durationInMinutes%60}"
    }
}

class Series(
    title: String,
    genre: Genre,
    releaseDate: LocalDate,
    isWatched: Boolean = false,
    comment: String? = null,
    rate: Int? = null,
    val parts: Map<Int, Int>
): Production(title, genre, releaseDate, isWatched, comment, rate){
    override fun toString(): String {
        return super.toString() +
                "parts: ${parts.entries.joinToString {"${it.key}:${it.value}"}}"
    }
}

fun getProductions() =
    listOf<Production>(
        Movie(
            title = "Inception",
            genre = Genre.ACTION,
            releaseDate = LocalDate.of(2010, 7, 30),
            isWatched = true,
            comment = "I was shocked during that movie",
            rate = 11,
            durationInMinutes = 148
        ),
        Movie(
            title = "TeneT",
            genre = Genre.ACTION,
            releaseDate = LocalDate.of(2020, 8, 26),
            isWatched = true,
            comment = "I understood nothing",
            rate = 7,
            durationInMinutes = 150
        ),
        Movie(
            title = "Nosferatu",
            genre = Genre.HORROR,
            releaseDate = LocalDate.of(2024, 2, 21),
            isWatched = true,
            rate = 8,
            durationInMinutes = 132
        ),
        Series(
            title = "The Vikings",
            genre = Genre.ACTION,
            releaseDate = LocalDate.of(2013, 3, 3),
            isWatched = true,
            comment = "For me, that was the best thing what Ive seen in my whole life",
            rate = 10,
            parts = mapOf(1 to 9, 2 to 10, 3 to 10, 4 to 20, 5 to 20, 6 to 20)
        ),
        Series(
            title = "Breaking Bad",
            genre = Genre.DRAMA,
            releaseDate = LocalDate.of(2008, 1, 20),
            isWatched = true,
            comment = "Main character's behaviour change was the best which Ive seen",
            rate = 10,
            parts = mapOf(1 to 7, 2 to 13, 3 to 13, 4 to 13, 5 to 16)
        ),
        Series(
            title = "Peaky Blinders",
            genre = Genre.ACTION,
            releaseDate = LocalDate.of(2013, 9, 12),
            isWatched = true,
            comment = "really masterpiece",
            rate = 10,
            parts = mapOf(1 to 6, 2 to 6, 3 to 6, 4 to 6, 5 to 6, 6 to 6)
        ),
    )


