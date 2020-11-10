package es.dgr.obmarvel.ui.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import es.dgr.obmarvel.databinding.ActivityHeroListBinding
import es.dgr.obmarvel.ui.common.ErrorSnackbarStyle
import es.dgr.obmarvel.ui.common.EventObserver
import es.dgr.obmarvel.ui.common.showLoading
import es.dgr.obmarvel.ui.common.showMessage
import es.dgr.obmarvel.ui.detail.HeroDetailActivity
import javax.inject.Inject

@AndroidEntryPoint
class HeroListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeroListBinding

    @Inject
    lateinit var viewModel: HeroListViewModel

    private lateinit var adapter: HeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroListBinding.inflate(layoutInflater).also { setContentView(it.root) }
        setUpRecycler()

        viewModel.run {
            model.observe(this@HeroListActivity, Observer(::updateUi))
            detailTransition.observe(this@HeroListActivity, EventObserver(::goToDetail))
        }
    }

    private fun setUpRecycler() {
        adapter = HeroAdapter(viewModel::onItemClicked)
        binding.rvHeroes.apply {
            this.adapter = this@HeroListActivity.adapter
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val lm = binding.rvHeroes.layoutManager as GridLayoutManager
                    if (lm.findLastCompletelyVisibleItemPosition() == this@HeroListActivity.adapter.itemCount - 1) {
                        viewModel.atTheEndOfScroll(size = this@HeroListActivity.adapter.itemCount)
                    }
                }
            })
        }
    }

    private fun updateUi(model: HeroListUiModel) {
        binding.loader.loader.showLoading(model == HeroListUiModel.Loading)

        when (model) {
            is HeroListUiModel.Content -> adapter.addItems(newItems = model.heroes)
            is HeroListUiModel.ErrorResponse -> showMessage(
                view = binding.clRoot as View,
                style = ErrorSnackbarStyle(message = model.message)
            )
            else -> {
            }
        }
    }

    private fun goToDetail(heroId: Int) {
        startActivity(
            HeroDetailActivity.create(
                context = this,
                heroId = heroId
            )
        )
    }
}
