package es.dgr.usecases

import es.dgr.domain.gateways.HeroesGateway

class GetHeroesUseCase(private val gateway: HeroesGateway) {
    suspend fun execute(offset: Int) = gateway.getHeroes(offset = offset)
}
