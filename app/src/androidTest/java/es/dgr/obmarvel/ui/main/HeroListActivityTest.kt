package es.dgr.obmarvel.ui.main

import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.agoda.kakao.intent.KIntent
import com.agoda.kakao.screen.Screen
import es.dgr.obmarvel.ui.detail.HeroDetailActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HeroListActivityTest {

    companion object {
        private const val HERO_NAME = "3-D Man"
        private const val HERO_ID = "HERO_ID"
        private const val ID_VALUE = 1011334
    }

    @Rule
    @JvmField
    var rule = IntentsTestRule(HeroListActivity::class.java)

    @Test
    fun first_item_title_test() {
        Screen.idle(2000L)
        Screen.onScreen<HeroListActivityScreen> {
            rvHeroes.firstChild<HeroListActivityScreen.HeroItem> {
                title.hasText(text = HERO_NAME)
            }
        }
    }

    @Test
    fun navigate_to_detail_test() {
        //Given
        Screen.idle(2000L)
        Screen.onScreen<HeroListActivityScreen> {
            rvHeroes.firstChild<HeroListActivityScreen.HeroItem> {
                this.click()
            }

            //When
            val detailIntent = KIntent {
                hasComponent(HeroDetailActivity::class.java.name)
                hasExtra(HERO_ID, ID_VALUE)
            }

            //Then
            detailIntent.intended()
        }
    }
}