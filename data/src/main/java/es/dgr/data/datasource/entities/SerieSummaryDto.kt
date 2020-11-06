package es.dgr.data.datasource.entities

import es.dgr.domain.entities.SerieSummary

data class SerieSummaryDto(
    val resourceURI: String,
    val name: String
)

fun SerieSummaryDto.mapToDomainObject(): SerieSummary =
    SerieSummary(resourceURI = resourceURI, name = name)

fun List<SerieSummaryDto>.mapToDomainObject(): List<SerieSummary> =
    this.map { it.mapToDomainObject() }
