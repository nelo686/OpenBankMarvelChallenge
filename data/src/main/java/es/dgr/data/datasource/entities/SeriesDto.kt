package es.dgr.data.datasource.entities

import es.dgr.domain.entities.Series

data class SeriesDto(
    val available: Int,
    val collectionURI: String,
    val items: List<SerieSummaryDto>,
    val returned: Int
)

fun SeriesDto.mapToDomainObject(): Series =
    Series(
        available = available,
        collectionURI = collectionURI,
        items = items.mapToDomainObject(),
        returned = returned
    )
