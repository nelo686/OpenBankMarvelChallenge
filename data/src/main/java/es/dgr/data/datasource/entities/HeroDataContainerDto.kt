package es.dgr.data.datasource.entities

data class HeroDataContainerDto(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<HeroDto>
)
