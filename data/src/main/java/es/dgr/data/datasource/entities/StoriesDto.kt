package es.dgr.data.datasource.entities

import es.dgr.domain.entities.Stories

data class StoriesDto(
    val available: Int,
    val collectionURI: String,
    val items: List<StorySummaryDto>,
    val returned: Int
)

fun StoriesDto.mapToDomainObject(): Stories =
    Stories(
        available = available,
        collectionURI = collectionURI,
        items = items.mapToDomainObject(),
        returned = returned
    )
