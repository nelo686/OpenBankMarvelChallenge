package es.dgr.obmarvel.ui.main

import android.view.View
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KTextView
import es.dgr.obmarvel.R
import org.hamcrest.Matcher

class HeroListActivityScreen : Screen<HeroListActivityScreen>() {

    val rvHeroes = KRecyclerView(
        builder = { withId(R.id.rvHeroes) },
        itemTypeBuilder = { itemType(::HeroItem) }
    )

    class HeroItem(parent: Matcher<View>) : KRecyclerItem<HeroItem>(parent) {
        val title = KTextView(parent) { withId(R.id.tv_title) }
    }
}
