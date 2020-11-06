package es.dgr.data.datasource.gateways

import arrow.core.Either
import es.dgr.data.datasource.agreement.HeroesService
import es.dgr.data.datasource.entities.HeroDataContainerDto
import es.dgr.data.datasource.entities.mapToDomainObject
import es.dgr.domain.entities.Hero
import es.dgr.domain.errors.DomainError
import es.dgr.domain.gateways.HeroesGateway
import java.sql.Timestamp

class HeroesDataGateway(
    private val service: HeroesService,
    private val timestamp: Timestamp,
    private val publicApiKey: String,
    private val privateApiKey: String
) : HeroesGateway {

    override suspend fun getHeroes(offset: Int): Either<DomainError, List<Hero>> = try {
        val container: HeroDataContainerDto = service.getHeroes(
            offset = offset,
            timeStamp = timestamp.toString(),
            apikey = publicApiKey,
            hash = timestamp.toString().plus(privateApiKey).plus(publicApiKey).md5()
        ).data
        Either.right(container.results.mapToDomainObject())
    } catch (e: Exception) {
        Either.left(e.parseErrorFormResponse())
    }

    override suspend fun getHeroDetails(heroId: Int): Either<DomainError, Hero> = try {
        val container: HeroDataContainerDto =
            service.getHeroDetails(
                heroId = heroId,
                timeStamp = timestamp.toString(),
                apikey = publicApiKey,
                hash = timestamp.toString().plus(privateApiKey).plus(publicApiKey).md5()
            ).data
        Either.right(container.results.first().mapToDomainObject())
    } catch (e: Exception) {
        Either.left(e.parseErrorFormResponse())
    }
}
