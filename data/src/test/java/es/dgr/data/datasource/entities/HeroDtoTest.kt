package es.dgr.data.datasource.entities

import es.dgr.data.datasource.stub.StubData
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test

class HeroDtoTest {

    @Test
    fun map_to_domain_single_object_test() {
        val expected = StubData.heroes.first()
        val actual = StubData.heroesDtos.first().mapToDomainObject()
        actual shouldBeEqualTo expected
    }

    @Test
    fun map_to_domain_object_list_test() {
        val expected = StubData.heroes
        val actual = StubData.heroesDtos.mapToDomainObject()
        actual shouldBeEqualTo expected
    }
}
