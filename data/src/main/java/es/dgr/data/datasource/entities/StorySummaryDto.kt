package es.dgr.data.datasource.entities

import es.dgr.domain.entities.StorySummary

data class StorySummaryDto(
    val resourceURI: String,
    val name: String,
    var type: String
)

fun StorySummaryDto.mapToDomainObject(): StorySummary =
    StorySummary(resourceURI = resourceURI, name = name, type = type)

fun List<StorySummaryDto>.mapToDomainObject(): List<StorySummary> =
    this.map { it.mapToDomainObject() }
