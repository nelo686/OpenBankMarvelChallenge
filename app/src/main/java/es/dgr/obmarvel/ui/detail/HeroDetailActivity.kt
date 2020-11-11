package es.dgr.obmarvel.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import coil.load
import dagger.hilt.android.AndroidEntryPoint
import es.dgr.domain.entities.*
import es.dgr.obmarvel.R
import es.dgr.obmarvel.databinding.ActivityHeroDetailBinding
import es.dgr.obmarvel.databinding.ViewDetailRecyclerBinding
import es.dgr.obmarvel.databinding.ViewHeaderBinding
import es.dgr.obmarvel.ui.common.ErrorSnackbarStyle
import es.dgr.obmarvel.ui.common.EventObserver
import es.dgr.obmarvel.ui.common.showLoading
import es.dgr.obmarvel.ui.common.showMessage
import es.dgr.obmarvel.ui.detail.adapters.*
import es.dgr.obmarvel.ui.web.WebActivity
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class HeroDetailActivity : AppCompatActivity() {

    companion object Builder {
        private const val HERO_ID = "HERO_ID"

        fun create(context: Context, heroId: Int) =
            Intent(context, HeroDetailActivity::class.java).apply {
                putExtra(HERO_ID, heroId)
            }
    }

    @Inject
    lateinit var viewModel: HeroDetailViewModel

    private lateinit var binding: ActivityHeroDetailBinding

    private lateinit var comicsAdapter: ComicAdapter
    private lateinit var seriesAdapter: SerieAdapter
    private lateinit var storiesAdapter: StoryAdapter
    private lateinit var eventsAdapter: EventAdapter
    private lateinit var urlsAdapter: UrlAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroDetailBinding.inflate(layoutInflater).also { setContentView(it.root) }

        setUpActionBar()
        setUpRecyclerViews()
        viewModel.run {
            onViewCreated(heroId = intent.extras?.getInt(HERO_ID) ?: -1)
            model.observe(this@HeroDetailActivity, Observer(::updateUi))
            webTransition.observe(this@HeroDetailActivity, EventObserver(::navigateToWeb))
        }
    }

    override fun onDestroy() {
        viewModel::onDestroy
        super.onDestroy()
    }

    private fun setUpActionBar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun setUpRecyclerViews() {
        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        comicsAdapter = ComicAdapter {}
        binding.comicsLayout.recycler.apply {
            adapter = comicsAdapter
            addItemDecoration(divider)
            tag = getString(R.string.comics_header)
        }

        seriesAdapter = SerieAdapter {}
        binding.seriesLayout.recycler.apply {
            adapter = seriesAdapter
            addItemDecoration(divider)
            tag = getString(R.string.series_header)
        }

        storiesAdapter = StoryAdapter {}
        binding.storiesLayout.recycler.apply {
            adapter = storiesAdapter
            addItemDecoration(divider)
            tag = getString(R.string.stories_header)
        }

        eventsAdapter = EventAdapter {}
        binding.eventsLayout.recycler.apply {
            adapter = eventsAdapter
            addItemDecoration(divider)
            tag = getString(R.string.events_header)
        }

        urlsAdapter = UrlAdapter(viewModel::onItemClicked)
        binding.urlsLayout.recycler.apply {
            adapter = urlsAdapter
            addItemDecoration(divider)
            tag = getString(R.string.urls_header)
        }
    }

    private fun updateUi(model: HeroDetailUiModel) {
        binding.loader.loader.showLoading(model == HeroDetailUiModel.Loading)

        when (model) {
            is HeroDetailUiModel.Content -> setContent(hero = model.hero)
            is HeroDetailUiModel.ErrorResponse -> showMessage(
                view = binding.clRoot as View,
                style = ErrorSnackbarStyle(message = model.message)
            )
            else -> {}
        }
    }

    private fun setContent(hero: Hero) {
        setAvatar(uri = "${hero.thumbnail.path}.${hero.thumbnail.extension}")
        setName(name = hero.name)
        setBio(description = hero.description)

        buildSummary(type = SummaryType.ComicsSummaryType, items = hero.comics.items)
        buildSummary(type = SummaryType.SeriesSummaryType, items = hero.series.items)
        buildSummary(type = SummaryType.StoriesSummaryType, items = hero.stories.items)
        buildSummary(type = SummaryType.EventsSummaryType, items = hero.events.items)
        buildSummary(type = SummaryType.UrlsSummaryType, items = hero.urls)
    }

    private fun setAvatar(uri: String) {
        binding.ivAvatar.load(uri = uri)
    }

    private fun setName(name: String) {
        supportActionBar?.title = name
    }

    private fun setBio(description: String) {
        when {
            description.isNotEmpty() -> binding.tvBio.text = description
            else -> binding.tvBio.text = getString(R.string.not_available)
        }
        showSummaryHeader(binding = binding.vBioHeader, title = getString(R.string.bio_header))
    }

    private fun showSummaryHeader(binding: ViewHeaderBinding, title: String) = with(binding) {
        tvHeaderTitle.text = title
        root.visibility = View.VISIBLE
    }

    private fun buildSummary(type: SummaryType, items: List<Any>) =
        when (items.isEmpty()) {
            true -> showEmptySummaryText(summaryType = type)
            false -> setList(summaryType = type, items = items)
        }

    private fun showEmptySummaryText(summaryType: SummaryType) =
        when (summaryType) {
            SummaryType.ComicsSummaryType -> {
                showEmptySummary(binding = binding.comicsLayout, itemType = getString(R.string.comics_header))
                showSummaryHeader(binding = binding.vComicsHeader, title = getString(R.string.comics_header))
            }
            SummaryType.SeriesSummaryType -> {
                showEmptySummary(binding = binding.seriesLayout, itemType = getString(R.string.series_header))
                showSummaryHeader(binding = binding.vSeriesHeader, title = getString(R.string.series_header))
            }
            SummaryType.StoriesSummaryType -> {
                showEmptySummary(
                    binding = binding.storiesLayout,
                    itemType = getString(R.string.stories_header)
                )
                showSummaryHeader(binding = binding.vStoriesHeader, title = getString(R.string.stories_header))
            }
            SummaryType.EventsSummaryType -> {
                showEmptySummary(binding = binding.eventsLayout, itemType = getString(R.string.events_header))
                showSummaryHeader(binding = binding.vEventsHeader, title = getString(R.string.events_header))
            }
            SummaryType.UrlsSummaryType -> {
                showEmptySummary(binding = binding.urlsLayout, itemType = getString(R.string.urls_header))
                showSummaryHeader(binding = binding.vUrlsHeader, title = getString(R.string.urls_header))
            }
        }

    private fun showEmptySummary(binding: ViewDetailRecyclerBinding, itemType: String) = with(binding) {
        recycler.visibility = View.GONE
        tvEmpty.text = String.format(getString(R.string.empty_summary), itemType.toLowerCase(Locale.ROOT))
        tvEmpty.visibility = View.VISIBLE
    }

    private fun setList(summaryType: SummaryType, items: List<Any>) =
        when (summaryType) {
            SummaryType.ComicsSummaryType -> {
                comicsAdapter.items = items as List<ComicSummary>
                showSummaryHeader(binding = binding.vComicsHeader, title = getString(R.string.comics_header))
            }
            SummaryType.SeriesSummaryType -> {
                seriesAdapter.items = items as List<SerieSummary>
                showSummaryHeader(binding = binding.vSeriesHeader, title = getString(R.string.series_header))
            }
            SummaryType.StoriesSummaryType -> {
                storiesAdapter.items = items as List<StorySummary>
                showSummaryHeader(binding = binding.vStoriesHeader, title = getString(R.string.stories_header))
            }
            SummaryType.EventsSummaryType -> {
                eventsAdapter.items = items as List<EventSummary>
                showSummaryHeader(binding = binding.vEventsHeader, title = getString(R.string.events_header))
            }
            SummaryType.UrlsSummaryType -> {
                urlsAdapter.items = items as List<Url>
                showSummaryHeader(binding = binding.vUrlsHeader, title = getString(R.string.urls_header))
            }
        }

    private fun navigateToWeb(url: String) {
        startActivity(WebActivity.create(context = this, url = url))
    }
}
