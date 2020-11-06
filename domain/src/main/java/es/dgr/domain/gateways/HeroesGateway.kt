package es.dgr.domain.gateways

import arrow.core.Either
import es.dgr.domain.entities.Hero
import es.dgr.domain.errors.DomainError

interface HeroesGateway {
    suspend fun getHeroes(offset: Int): Either<DomainError, List<Hero>>
    suspend fun getHeroDetails(heroId: Int): Either<DomainError, Hero>
}
