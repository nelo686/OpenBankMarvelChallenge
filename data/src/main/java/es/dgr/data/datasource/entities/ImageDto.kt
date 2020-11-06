package es.dgr.data.datasource.entities

import es.dgr.domain.entities.Image

data class ImageDto(
    val path: String,
    val extension: String
)

fun ImageDto.mapToDomainObject(): Image =
    Image(path = path, extension = extension)
