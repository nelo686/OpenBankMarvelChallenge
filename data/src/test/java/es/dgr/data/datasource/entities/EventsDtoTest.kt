package es.dgr.data.datasource.entities

import es.dgr.data.datasource.stub.StubData
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test

class EventsDtoTest {

    @Test
    fun map_to_domain_single_object_test() {
        val expected = StubData.heroes.first().events
        val actual = StubData.heroesDtos.first().events.mapToDomainObject()
        actual shouldBeEqualTo expected
    }
}