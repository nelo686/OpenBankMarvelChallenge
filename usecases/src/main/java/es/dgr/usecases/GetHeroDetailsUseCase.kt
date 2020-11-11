package es.dgr.usecases

import es.dgr.domain.gateways.HeroesGateway

class GetHeroDetailsUseCase(private val gateway: HeroesGateway) {
    suspend fun execute(heroId: Int) = gateway.getHeroDetails(heroId = heroId)
}
