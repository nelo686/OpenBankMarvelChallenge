package es.dgr.data.datasource.gateways

import arrow.core.Either
import com.nhaarman.mockitokotlin2.whenever
import es.dgr.data.datasource.agreement.HeroesService
import es.dgr.data.datasource.entities.mapToDomainObject
import es.dgr.data.datasource.stub.StubData
import es.dgr.domain.entities.Hero
import es.dgr.domain.errors.DomainError
import es.dgr.domain.gateways.HeroesGateway
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import java.sql.Timestamp

class HeroesDataGatewayTest {

    companion object {
        private const val PUBLIC_API_KEY = "4eaf5f44be3cac7577d71195c00f5afa"
        private const val PRIVATE_API_KEY = "f3a20441ebe46366d46941c346061caa908c0c9a"

        private const val NO_OFFSET = 0
        private const val UNKNOWN = "UNKNOWN"
        private const val HERO_ID = 1011334
    }

    @Mock
    lateinit var service: HeroesService

    @Mock
    lateinit var timestamp: Timestamp

    private val gateway: HeroesGateway by lazy {
        HeroesDataGateway(
            service = service,
            timestamp = timestamp,
            publicApiKey = PUBLIC_API_KEY,
            privateApiKey = PRIVATE_API_KEY
        )
    }

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun ask_for_heroes_and_get_an_either_with_heroes() {
        runBlocking {
            whenever(
                service.getHeroes(
                    offset = NO_OFFSET,
                    timeStamp = timestamp.toString(),
                    apikey = PUBLIC_API_KEY,
                    hash = timestamp.toString().plus(PRIVATE_API_KEY).plus(PUBLIC_API_KEY).md5()
                )
            ).thenReturn(StubData.wrapperDto)

            val expected: Either<DomainError, List<Hero>> =
                Either.right(StubData.heroesDtos.mapToDomainObject())
            val actual = gateway.getHeroes(offset = NO_OFFSET)

            actual shouldBeEqualTo expected
        }
    }

    @Test
    fun ask_for_heroes_and_get_an_either_with_error() {
        runBlocking {
            whenever(
                service.getHeroes(
                    offset = NO_OFFSET,
                    timeStamp = timestamp.toString(),
                    apikey = PUBLIC_API_KEY,
                    hash = timestamp.toString().plus(PRIVATE_API_KEY).plus(PUBLIC_API_KEY).md5()
                )
            ).thenAnswer { throw Exception() }
            val expected: Either<DomainError, List<Hero>> =
                Either.left(DomainError.DefaultError(message = UNKNOWN))
            val actual = gateway.getHeroes(offset = NO_OFFSET)
            actual shouldBeEqualTo expected
        }
    }

    @Test
    fun ask_for_hero_details_and_get_an_either_with_a_hero() {
        runBlocking {
            whenever(
                service.getHeroDetails(
                    heroId = HERO_ID,
                    timeStamp = timestamp.toString(),
                    apikey = PUBLIC_API_KEY,
                    hash = timestamp.toString().plus(PRIVATE_API_KEY).plus(PUBLIC_API_KEY).md5()
                )
            ).thenReturn(StubData.wrapperDto)

            val expected = Either.right(
                StubData.heroesDtos.first().mapToDomainObject()
            )
            var actual = gateway.getHeroDetails(heroId = HERO_ID)

            actual shouldBeEqualTo expected
        }
    }

    @Test
    fun ask_for_hero_details_and_get_an_either_with_error() {
        runBlocking {
            whenever(
                service.getHeroDetails(
                    heroId = HERO_ID,
                    timeStamp = timestamp.toString(),
                    apikey = PUBLIC_API_KEY,
                    hash = timestamp.toString().plus(PRIVATE_API_KEY).plus(PUBLIC_API_KEY).md5()
                )
            ).thenAnswer { throw Exception() }
            val expected: Either<DomainError, Hero> =
                Either.left(DomainError.DefaultError(message = UNKNOWN))
            val actual = gateway.getHeroDetails(heroId = HERO_ID)
            actual shouldBeEqualTo expected
        }
    }
}
