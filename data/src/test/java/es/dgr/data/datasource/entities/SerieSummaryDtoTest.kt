package es.dgr.data.datasource.entities

import es.dgr.data.datasource.stub.StubData
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test

class SerieSummaryDtoTest {

    @Test
    fun map_to_domain_single_object_test() {
        val expected = StubData.heroes.first().series.items.first()
        val actual = StubData.heroesDtos.first().series.items.first().mapToDomainObject()
        actual shouldBeEqualTo expected
    }

    @Test
    fun map_to_domain_object_list_test() {
        val expected = StubData.heroes.first().series.items
        val actual = StubData.heroesDtos.first().series.items.mapToDomainObject()
        actual shouldBeEqualTo expected
    }
}