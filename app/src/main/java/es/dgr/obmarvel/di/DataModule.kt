package es.dgr.obmarvel.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import es.dgr.data.datasource.agreement.HeroesService
import es.dgr.data.datasource.gateways.HeroesDataGateway
import es.dgr.domain.gateways.HeroesGateway
import es.dgr.obmarvel.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.sql.Timestamp
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .build()

    @Provides
    fun provideHeroesService(retrofit: Retrofit): HeroesService =
        retrofit.create(HeroesService::class.java)

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