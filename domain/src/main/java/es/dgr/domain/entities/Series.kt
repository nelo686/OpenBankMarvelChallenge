package es.dgr.domain.entities

data class Series(
    val available: Int,
    val collectionURI: String,
    val items: List<SerieSummary>,
    val returned: Int
)
