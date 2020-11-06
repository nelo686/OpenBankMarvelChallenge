package es.dgr.data.datasource.entities

import es.dgr.domain.entities.EventSummary

data class EventSummaryDto(
    val resourceURI: String,
    val name: String
)

fun EventSummaryDto.mapToDomainObject(): EventSummary =
    EventSummary(resourceURI = resourceURI, name = name)

fun List<EventSummaryDto>.mapToDomainObject(): List<EventSummary> =
    this.map { it.mapToDomainObject() }
