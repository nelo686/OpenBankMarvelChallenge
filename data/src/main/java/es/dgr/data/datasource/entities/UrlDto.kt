package es.dgr.data.datasource.entities

import es.dgr.domain.entities.Url

data class UrlDto(
    val type: String,
    val url: String
)

fun UrlDto.mapToDomainObject(): Url = Url(type = type, url = url)

fun List<UrlDto>.mapToDomainObject(): List<Url> = this.map { it.mapToDomainObject() }
