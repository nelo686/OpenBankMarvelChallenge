package es.dgr.data.datasource.entities

import es.dgr.data.datasource.stub.StubData
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test

class StorySummaryDtoTest {

    @Test
    fun map_to_domain_single_object_test() {
        val expected = StubData.heroes.first().stories.items.first()
        val actual = StubData.heroesDtos.first().stories.items.first().mapToDomainObject()
        actual shouldBeEqualTo expected
    }

    @Test
    fun map_to_domain_object_list_test() {
        val expected = StubData.heroes.first().stories.items
        val actual = StubData.heroesDtos.first().stories.items.mapToDomainObject()
        actual shouldBeEqualTo expected
    }
}
