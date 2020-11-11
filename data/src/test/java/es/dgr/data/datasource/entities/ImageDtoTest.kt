package es.dgr.data.datasource.entities

import es.dgr.data.datasource.stub.StubData
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test

class ImageDtoTest {

    @Test
    fun map_to_domain_single_object_test() {
        val expected = StubData.heroes.first().thumbnail
        val actual = StubData.heroesDtos.first().thumbnail.mapToDomainObject()
        actual shouldBeEqualTo expected
    }
}
