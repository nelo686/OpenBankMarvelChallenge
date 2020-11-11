package es.dgr.data.datasource.entities

import es.dgr.data.datasource.stub.StubData
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test

class SeriesDtoTest {

    @Test
    fun map_to_domain_single_object_test() {
        val expected = StubData.heroes.first().series
        val actual = StubData.heroesDtos.first().series.mapToDomainObject()
        actual shouldBeEqualTo expected
    }
}