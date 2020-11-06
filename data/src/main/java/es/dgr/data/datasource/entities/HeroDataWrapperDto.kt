package es.dgr.data.datasource.entities

data class HeroDataWrapperDto(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val data: HeroDataContainerDto,
    val etag: String
)
