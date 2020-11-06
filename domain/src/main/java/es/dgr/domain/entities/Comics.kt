package es.dgr.domain.entities

data class Comics(
    val available: Int,
    val collectionURI: String,
    val items: List<ComicSummary>,
    val returned: Int
)
