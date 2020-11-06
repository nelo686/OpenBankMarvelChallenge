package es.dgr.domain.entities

data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<StorySummary>,
    val returned: Int
)
