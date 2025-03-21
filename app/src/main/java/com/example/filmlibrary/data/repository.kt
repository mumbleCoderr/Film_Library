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

