package es.dgr.data.datasource.entities

import es.dgr.data.datasource.stub.StubData
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test

class UrlDtoTest {

    @Test
    fun map_to_domain_single_object_test() {
        val expected = StubData.heroes.first().urls.first()
        val actual = StubData.heroesDtos.first().urls.first().mapToDomainObject()
        actual shouldBeEqualTo expected
    }

    @Test
    fun map_to_domain_object_list_test() {
        val expected = StubData.heroes.first().urls
        val actual = StubData.heroesDtos.first().urls.mapToDomainObject()
        actual shouldBeEqualTo expected
    }
}
