package es.dgr.data.datasource.entities

import es.dgr.data.datasource.stub.StubData
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test

class EventSummaryDtoTest {

    @Test
    fun map_to_domain_single_object_test() {
        val expected = StubData.heroes.first().events.items.first()
        val actual = StubData.heroesDtos.first().events.items.first().mapToDomainObject()
        actual shouldBeEqualTo expected
    }

    @Test
    fun map_to_domain_object_list_test() {
        val expected = StubData.heroes.first().events.items
        val actual = StubData.heroesDtos.first().events.items.mapToDomainObject()
        actual shouldBeEqualTo expected
    }
}
