package es.dgr.obmarvel.ui.detail

import android.view.View
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KTextView
import es.dgr.obmarvel.R
import org.hamcrest.Matcher

class HeroDetailActivityScreen : Screen<HeroDetailActivityScreen>() {

    val bio = KTextView { withId(R.id.tvBio) }
    val rvComics = KRecyclerView(
        builder = { withTag("Comics") },
        itemTypeBuilder = { itemType(::SummaryItem) }
    )
    val rvSeries = KRecyclerView(
        builder = { withTag("Series") },
        itemTypeBuilder = { itemType(::SummaryItem) }
    )
    val rvStories = KRecyclerView(
        builder = { withTag("Stories") },
        itemTypeBuilder = { itemType(::SummaryItem) }
    )
    val rvEvents = KRecyclerView(
        builder = { withTag("Events") },
        itemTypeBuilder = { itemType(::SummaryItem) }
    )

    class SummaryItem(parent: Matcher<View>) : KRecyclerItem<SummaryItem>(parent) {
        val title = KTextView(parent) { withId(R.id.tvTitle) }
    }
}
