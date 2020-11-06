package es.dgr.data.datasource.entities

import es.dgr.domain.entities.Comics

data class ComicsDto(
    val available: Int,
    val collectionURI: String,
    val items: List<ComicSummaryDto>,
    val returned: Int
)

fun ComicsDto.mapToDomainObject(): Comics =
    Comics(
        available = available,
        collectionURI = collectionURI,
        items = items.mapToDomainObject(),
        returned = returned
    )
