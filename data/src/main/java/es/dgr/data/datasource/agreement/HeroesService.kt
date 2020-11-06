package es.dgr.data.datasource.agreement

import es.dgr.data.datasource.entities.HeroDataWrapperDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HeroesService {

    companion object {
        private const val HEROES_LIST = "v1/public/characters"
        private const val HERO_DETAILS = "v1/public/characters/{characterId}"
    }

    @GET(HEROES_LIST)
    suspend fun getHeroes(
        @Query("offset") offset: Int,
        @Query("ts") timeStamp: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String
    ): HeroDataWrapperDto

    @GET(HERO_DETAILS)
    suspend fun getHeroDetails(
        @Path("characterId") heroId: Int,
        @Query("ts") timeStamp: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String
    ): HeroDataWrapperDto
}