package es.dgr.obmarvel.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import es.dgr.domain.gateways.HeroesGateway
import es.dgr.usecases.GetHeroDetailsUseCase
import es.dgr.usecases.GetHeroesUseCase

@Module
@InstallIn(ActivityRetainedComponent::class)
class UseCasesModule {

    @Provides
    fun getHeroesUseCaseProvider(gateway: HeroesGateway): GetHeroesUseCase =
        GetHeroesUseCase(gateway = gateway)

    @Provides
    fun getHeroDetailsUseCaseProvider(gateway: HeroesGateway): GetHeroDetailsUseCase =
        GetHeroDetailsUseCase(gateway = gateway)
}