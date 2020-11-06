package es.dgr.data.datasource.entities

import es.dgr.domain.entities.Hero
import java.util.*

data class HeroDto(
    val id: Int,
    val name: String,
    val description: String,
    val modified: Date,
    val resourceURI: String,
    val urls: List<UrlDto>,
    val thumbnail: ImageDto,
    val comics: ComicsDto,
    val stories: StoriesDto,
    val events: EventsDto,
    val series: SeriesDto
)

fun HeroDto.mapToDomainObject(): Hero =
    Hero(
        id = id,
        name = name,
        description = description,
        modified = modified,
        resourceURI = resourceURI,
        urls = urls.mapToDomainObject(),
        thumbnail = thumbnail.mapToDomainObject(),
        comics = comics.mapToDomainObject(),
        stories = stories.mapToDomainObject(),
        events = events.mapToDomainObject(),
        series = series.mapToDomainObject()
    )

fun List<HeroDto>.mapToDomainObject(): List<Hero> =
    this.map { it.mapToDomainObject() }
