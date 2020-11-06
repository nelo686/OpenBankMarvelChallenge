package es.dgr.data.datasource.entities

import es.dgr.domain.entities.Events

data class EventsDto(
    val available: Int,
    val collectionURI: String,
    val items: List<EventSummaryDto>,
    val returned: Int
)

fun EventsDto.mapToDomainObject(): Events =
    Events(
        available = available,
        collectionURI = collectionURI,
        items = items.mapToDomainObject(),
        returned = returned
    )
