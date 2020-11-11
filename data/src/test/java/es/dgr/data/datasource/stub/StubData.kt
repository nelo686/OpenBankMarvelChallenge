package es.dgr.data.datasource.stub

import es.dgr.data.datasource.entities.*
import es.dgr.domain.entities.*
import java.text.SimpleDateFormat

class StubData {
    companion object {

        //I`ll create two heroes only to not waste too many time
        val heroes = listOf<Hero>(
            Hero(
                id = 1011334,
                name = "3-D Man",
                description = "",
                modified = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").parse("2014-04-29T14:18:17-0400"),
                thumbnail = Image(
                    path = "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784",
                    extension = "jpg"
                ),
                resourceURI = "http://gateway.marvel.com/v1/public/characters/1011334",
                comics = Comics(
                    available = 2,
                    collectionURI = "http://gateway.marvel.com/v1/public/characters/1011334/comics",
                    items = listOf(
                        ComicSummary(
                            resourceURI = "http://gateway.marvel.com/v1/public/comics/21366",
                            name = "Avengers: The Initiative (2007) #14"
                        ),
                        ComicSummary(
                            resourceURI = "http://gateway.marvel.com/v1/public/comics/24571",
                            name = "Avengers: The Initiative (2007) #14 (SPOTLIGHT VARIANT)"
                        )
                    ),
                    returned = 2
                ),
                series = Series(
                    available = 2,
                    collectionURI = "http://gateway.marvel.com/v1/public/characters/1011334/series",
                    items = listOf(
                        SerieSummary(
                            resourceURI = "http://gateway.marvel.com/v1/public/series/1945",
                            name = "Avengers: The Initiative (2007 - 2010)"
                        ),
                        SerieSummary(
                            resourceURI = "http://gateway.marvel.com/v1/public/series/2005",
                            name = "Deadpool (1997 - 2002)"
                        )
                    ), returned = 2
                ),
                stories = Stories(
                    available = 2,
                    collectionURI = "http://gateway.marvel.com/v1/public/characters/1011334/stories",
                    items = listOf(
                        StorySummary(
                            resourceURI = "http://gateway.marvel.com/v1/public/stories/19947",
                            name = "Cover #19947",
                            type = "cover"
                        ),
                        StorySummary(
                            resourceURI = "http://gateway.marvel.com/v1/public/stories/19948",
                            name = "The 3-D Man!",
                            type = "cover"
                        )
                    ),
                    returned = 2
                ), events = Events(
                    available = 1,
                    collectionURI = "http://gateway.marvel.com/v1/public/characters/1011334/events",
                    items = listOf(
                        EventSummary(
                            resourceURI = "http://gateway.marvel.com/v1/public/events/269",
                            name = "Secret Invasion"
                        )
                    ), returned = 1
                ),
                urls = listOf(
                    Url(
                        type = "detail",
                        url = "http://marvel.com/comics/characters/1011334/3-d_man?utm_campaign=apiRef&utm_source=4eaf5f44be3cac7577d71195c00f5afa"
                    ),
                    Url(
                        type = "wiki",
                        url = "http://marvel.com/universe/3-D_Man_(Chandler)?utm_campaign=apiRef&utm_source=4eaf5f44be3cac7577d71195c00f5afa"
                    ),
                    Url(
                        type = "comiclink",
                        url = "http://marvel.com/comics/characters/1011334/3-d_man?utm_campaign=apiRef&utm_source=4eaf5f44be3cac7577d71195c00f5afa"
                    )
                )
            ),
            Hero(
                id = 1017100,
                name = "A-Bomb (HAS)",
                description = "Rick Jones has been Hulk's best bud since day one, but now he's more than a friend...he's a teammate! Transformed by a Gamma energy explosion, A-Bomb's thick, armored skin is just as strong and powerful as it is blue. And when he curls into action, he uses it like a giant bowling ball of destruction! ",
                modified = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").parse("2014-04-29T14:18:17-0400"),
                thumbnail = Image(
                    path = "http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16",
                    extension = "jpg"
                ),
                resourceURI = "http://gateway.marvel.com/v1/public/characters/1017100",
                comics = Comics(
                    available = 2,
                    collectionURI = "http://gateway.marvel.com/v1/public/characters/1017100/comics",
                    items = listOf(
                        ComicSummary(
                            resourceURI = "http://gateway.marvel.com/v1/public/comics/40632",
                            name = "Hulk (2008) #53"
                        ),
                        ComicSummary(
                            resourceURI = "http://gateway.marvel.com/v1/public/comics/40630",
                            name = "Hulk (2008) #54"
                        )
                    ),
                    returned = 2
                ),
                series = Series(
                    available = 2,
                    collectionURI = "http://gateway.marvel.com/v1/public/characters/1017100/series",
                    items = listOf(
                        SerieSummary(
                            resourceURI = "http://gateway.marvel.com/v1/public/series/17765",
                            name = "FREE COMIC BOOK DAY 2013 1 (2013)"
                        ),
                        SerieSummary(
                            resourceURI = "http://gateway.marvel.com/v1/public/series/3374",
                            name = "Hulk (2008 - 2012)"
                        )
                    ), returned = 2
                ),
                stories = Stories(
                    available = 2,
                    collectionURI = "http://gateway.marvel.com/v1/public/characters/1017100/stories",
                    items = listOf(
                        StorySummary(
                            resourceURI = "http://gateway.marvel.com/v1/public/stories/92078",
                            name = "Hulk (2008) #55",
                            type = "cover"
                        ),
                        StorySummary(
                            resourceURI = "http://gateway.marvel.com/v1/public/stories/92079",
                            name = "Interior #92079",
                            type = "interiorStory"
                        )
                    ),
                    returned = 2
                ), events = Events(
                    available = 0,
                    collectionURI = "http://gateway.marvel.com/v1/public/characters/1017100/events",
                    items = emptyList(),
                    returned = 0
                ),
                urls = listOf(
                    Url(
                        type = "detail",
                        url = "http://marvel.com/comics/characters/1017100/a-bomb_has?utm_campaign=apiRef&utm_source=4eaf5f44be3cac7577d71195c00f5afa"
                    ),
                    Url(
                        type = "comiclink",
                        url = "http://marvel.com/comics/characters/1017100/a-bomb_has?utm_campaign=apiRef&utm_source=4eaf5f44be3cac7577d71195c00f5afa"
                    )
                )
            )
        )

        //I`ll create two heroes only to not waste too many time
        val heroesDtos = listOf<HeroDto>(
            HeroDto(
                id = 1011334,
                name = "3-D Man",
                description = "",
                modified = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").parse("2014-04-29T14:18:17-0400"),
                thumbnail = ImageDto(
                    path = "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784",
                    extension = "jpg"
                ),
                resourceURI = "http://gateway.marvel.com/v1/public/characters/1011334",
                comics = ComicsDto(
                    available = 2,
                    collectionURI = "http://gateway.marvel.com/v1/public/characters/1011334/comics",
                    items = listOf(
                        ComicSummaryDto(
                            resourceURI = "http://gateway.marvel.com/v1/public/comics/21366",
                            name = "Avengers: The Initiative (2007) #14"
                        ),
                        ComicSummaryDto(
                            resourceURI = "http://gateway.marvel.com/v1/public/comics/24571",
                            name = "Avengers: The Initiative (2007) #14 (SPOTLIGHT VARIANT)"
                        )
                    ),
                    returned = 2
                ),
                series = SeriesDto(
                    available = 2,
                    collectionURI = "http://gateway.marvel.com/v1/public/characters/1011334/series",
                    items = listOf(
                        SerieSummaryDto(
                            resourceURI = "http://gateway.marvel.com/v1/public/series/1945",
                            name = "Avengers: The Initiative (2007 - 2010)"
                        ),
                        SerieSummaryDto(
                            resourceURI = "http://gateway.marvel.com/v1/public/series/2005",
                            name = "Deadpool (1997 - 2002)"
                        )
                    ), returned = 2
                ),
                stories = StoriesDto(
                    available = 2,
                    collectionURI = "http://gateway.marvel.com/v1/public/characters/1011334/stories",
                    items = listOf(
                        StorySummaryDto(
                            resourceURI = "http://gateway.marvel.com/v1/public/stories/19947",
                            name = "Cover #19947",
                            type = "cover"
                        ),
                        StorySummaryDto(
                            resourceURI = "http://gateway.marvel.com/v1/public/stories/19948",
                            name = "The 3-D Man!",
                            type = "cover"
                        )
                    ),
                    returned = 2
                ), events = EventsDto(
                    available = 1,
                    collectionURI = "http://gateway.marvel.com/v1/public/characters/1011334/events",
                    items = listOf(
                        EventSummaryDto(
                            resourceURI = "http://gateway.marvel.com/v1/public/events/269",
                            name = "Secret Invasion"
                        )
                    ), returned = 1
                ),
                urls = listOf(
                    UrlDto(
                        type = "detail",
                        url = "http://marvel.com/comics/characters/1011334/3-d_man?utm_campaign=apiRef&utm_source=4eaf5f44be3cac7577d71195c00f5afa"
                    ),
                    UrlDto(
                        type = "wiki",
                        url = "http://marvel.com/universe/3-D_Man_(Chandler)?utm_campaign=apiRef&utm_source=4eaf5f44be3cac7577d71195c00f5afa"
                    ),
                    UrlDto(
                        type = "comiclink",
                        url = "http://marvel.com/comics/characters/1011334/3-d_man?utm_campaign=apiRef&utm_source=4eaf5f44be3cac7577d71195c00f5afa"
                    )
                )
            ),
            HeroDto(
                id = 1017100,
                name = "A-Bomb (HAS)",
                description = "Rick Jones has been Hulk's best bud since day one, but now he's more than a friend...he's a teammate! Transformed by a Gamma energy explosion, A-Bomb's thick, armored skin is just as strong and powerful as it is blue. And when he curls into action, he uses it like a giant bowling ball of destruction! ",
                modified = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").parse("2014-04-29T14:18:17-0400"),
                thumbnail = ImageDto(
                    path = "http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16",
                    extension = "jpg"
                ),
                resourceURI = "http://gateway.marvel.com/v1/public/characters/1017100",
                comics = ComicsDto(
                    available = 2,
                    collectionURI = "http://gateway.marvel.com/v1/public/characters/1017100/comics",
                    items = listOf(
                        ComicSummaryDto(
                            resourceURI = "http://gateway.marvel.com/v1/public/comics/40632",
                            name = "Hulk (2008) #53"
                        ),
                        ComicSummaryDto(
                            resourceURI = "http://gateway.marvel.com/v1/public/comics/40630",
                            name = "Hulk (2008) #54"
                        )
                    ),
                    returned = 2
                ),
                series = SeriesDto(
                    available = 2,
                    collectionURI = "http://gateway.marvel.com/v1/public/characters/1017100/series",
                    items = listOf(
                        SerieSummaryDto(
                            resourceURI = "http://gateway.marvel.com/v1/public/series/17765",
                            name = "FREE COMIC BOOK DAY 2013 1 (2013)"
                        ),
                        SerieSummaryDto(
                            resourceURI = "http://gateway.marvel.com/v1/public/series/3374",
                            name = "Hulk (2008 - 2012)"
                        )
                    ), returned = 2
                ),
                stories = StoriesDto(
                    available = 2,
                    collectionURI = "http://gateway.marvel.com/v1/public/characters/1017100/stories",
                    items = listOf(
                        StorySummaryDto(
                            resourceURI = "http://gateway.marvel.com/v1/public/stories/92078",
                            name = "Hulk (2008) #55",
                            type = "cover"
                        ),
                        StorySummaryDto(
                            resourceURI = "http://gateway.marvel.com/v1/public/stories/92079",
                            name = "Interior #92079",
                            type = "interiorStory"
                        )
                    ),
                    returned = 2
                ), events = EventsDto(
                    available = 0,
                    collectionURI = "http://gateway.marvel.com/v1/public/characters/1017100/events",
                    items = emptyList(),
                    returned = 0
                ),
                urls = listOf(
                    UrlDto(
                        type = "detail",
                        url = "http://marvel.com/comics/characters/1017100/a-bomb_has?utm_campaign=apiRef&utm_source=4eaf5f44be3cac7577d71195c00f5afa"
                    ),
                    UrlDto(
                        type = "comiclink",
                        url = "http://marvel.com/comics/characters/1017100/a-bomb_has?utm_campaign=apiRef&utm_source=4eaf5f44be3cac7577d71195c00f5afa"
                    )
                )
            )
        )

        val wrapperDto = HeroDataWrapperDto(
            code = 200,
            status = "OK",
            copyright = "© 2020 MARVEL",
            attributionText = "Data provided by Marvel. © 2020 MARVEL",
            attributionHTML = "<a href=\\\"http://marvel.com\\\">Data provided by Marvel. © 2020 MARVEL</a>",
            data = HeroDataContainerDto(
                offset = 0,
                limit = 20,
                total = 1493,
                count = 20,
                results = heroesDtos
            ),
            etag = "0ebcfa5fe026624a873a52eca0706d48744aa424"
        )

    }
}
