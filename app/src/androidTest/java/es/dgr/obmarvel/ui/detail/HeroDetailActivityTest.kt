package es.dgr.obmarvel.ui.detail

import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.agoda.kakao.screen.Screen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HeroDetailActivityTest {

    companion object {
        private const val HERO_ID = "HERO_ID"
        private const val ID_VALUE = 1011334
        private const val ANOTHER_ID_VALUE = 1017100
        private const val EMPTY_BIO = "Not available"
        private const val COMIC_TITLE = "Avengers: The Initiative (2007) #14"
        private const val SERIE_TITLE = "Avengers: The Initiative (2007 - 2010)"
        private const val STORY_TITLE = "The 3-D Man!"
        private const val EVENT_TITLE = "Secret Invasion"
    }

    private val intent = Intent(
        ApplicationProvider.getApplicationContext(),
        HeroDetailActivity::class.java
    ).apply {
        putExtra(HERO_ID, ID_VALUE)
    }

    @get:Rule
    var activityRule = ActivityScenarioRule<HeroDetailActivity>(intent)

    @Test
    fun empty_bio_test() {
        Screen.idle(2000L)
        Screen.onScreen<HeroDetailActivityScreen> {
            bio.hasText(EMPTY_BIO)
        }
    }

    @Test
    fun not_empty_bio_test() {
        activityRule = ActivityScenarioRule<HeroDetailActivity>(
            Intent(
                ApplicationProvider.getApplicationContext(),
                HeroDetailActivity::class.java
            ).apply {
                putExtra(HERO_ID, ANOTHER_ID_VALUE)
            })

        Screen.idle(2000L)
        Screen.onScreen<HeroDetailActivityScreen> {
            bio.hasText(EMPTY_BIO)
        }
    }

    @Test
    fun first_comic_title_test() {
        Screen.idle(2000L)
        Screen.onScreen<HeroDetailActivityScreen> {
            rvComics.firstChild<HeroDetailActivityScreen.SummaryItem> {
                title.hasText(COMIC_TITLE)
            }
        }
    }

    @Test
    fun first_serie_title_test() {
        Screen.idle(2000L)
        Screen.onScreen<HeroDetailActivityScreen> {
            rvSeries.firstChild<HeroDetailActivityScreen.SummaryItem> {
                title.hasText(SERIE_TITLE)
            }
        }
    }

    @Test
    fun second_story_title_test() {
        Screen.idle(2000L)
        Screen.onScreen<HeroDetailActivityScreen> {
            rvStories.childAt<HeroDetailActivityScreen.SummaryItem>(1) {
                title.hasText(STORY_TITLE)
            }
        }
    }

    @Test
    fun first_event_title_test() {
        Screen.idle(2000L)
        Screen.onScreen<HeroDetailActivityScreen> {
            rvEvents.firstChild<HeroDetailActivityScreen.SummaryItem> {
                title.hasText(EVENT_TITLE)
            }
        }
    }
}