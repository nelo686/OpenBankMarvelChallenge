package es.dgr.data.datasource.entities

import es.dgr.domain.entities.ComicSummary

data class ComicSummaryDto(
    val resourceURI: String,
    val name: String
)

fun ComicSummaryDto.mapToDomainObject(): ComicSummary =
    ComicSummary(resourceURI = resourceURI, name = name)

fun List<ComicSummaryDto>.mapToDomainObject(): List<ComicSummary> =
    this.map { it.mapToDomainObject() }
