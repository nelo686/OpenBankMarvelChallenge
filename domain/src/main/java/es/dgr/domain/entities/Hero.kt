package es.dgr.domain.entities

import java.util.*

data class Hero(
    val id: Int,
    val name: String,
    val description: String,
    val modified: Date,
    val resourceURI: String,
    val urls: List<Url>,
    val thumbnail: Image,
    val comics: Comics,
    val stories: Stories,
    val events: Events,
    val series: Series
)
