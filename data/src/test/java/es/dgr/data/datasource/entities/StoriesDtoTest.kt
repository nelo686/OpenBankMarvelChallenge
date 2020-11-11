package es.dgr.data.datasource.entities

import es.dgr.data.datasource.stub.StubData
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test

class StoriesDtoTest {

    @Test
    fun map_to_domain_single_object_test() {
        val expected = StubData.heroes.first().stories
        val actual = StubData.heroesDtos.first().stories.mapToDomainObject()
        actual shouldBeEqualTo expected
    }
}
