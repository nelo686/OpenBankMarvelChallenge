package es.dgr.obmarvel.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import es.dgr.data.datasource.agreement.HeroesService
import es.dgr.data.datasource.gateways.HeroesDataGateway
import es.dgr.domain.gateways.HeroesGateway
import es.dgr.obmarvel.BuildConfig
import java.sql.Timestamp

@Module
@InstallIn(ApplicationComponent::class)
class GatewaysModule {

    @Provides
    fun timestampProvider(): Timestamp =
        Timestamp(System.currentTimeMillis())

    @Provides
    fun getHeroesGatewayProvider(
        service: HeroesService,
        timestamp: Timestamp,
    ): HeroesGateway =
        HeroesDataGateway(
            service = service,
            timestamp = timestamp,
            publicApiKey = BuildConfig.PUBLIC_API_KEY,
            privateApiKey = BuildConfig.PRIVATE_API_KEY
        )
}