package es.dgr.obmarvel.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.dgr.obmarvel.ui.common.Event
import es.dgr.obmarvel.ui.common.Scope
import es.dgr.obmarvel.ui.common.message
import es.dgr.usecases.GetHeroesUseCase
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HeroListViewModel @ViewModelInject constructor(
    private val useCase: GetHeroesUseCase
) : ViewModel(), Scope by Scope.Impl() {

    private val _model = MutableLiveData<HeroListUiModel>()
    val model: LiveData<HeroListUiModel>
        get() = _model

    private val _detailTransition = MutableLiveData<Event<Int>>()
    val detailTransition: LiveData<Event<Int>>
        get() = _detailTransition

    init {
        initScope()
        getHeroes()
    }

    private fun getHeroes(offset: Int = 0) {
        launch {
            _model.value = HeroListUiModel.Loading
            withContext(ioDispatcher) {
                useCase.execute(offset = offset)
            }.fold(
                { _model.value = HeroListUiModel.ErrorResponse(it.message()) },
                { _model.value = HeroListUiModel.Content(heroes = it) }
            )
        }
    }

    fun onItemClicked(heroId: Int) {
        _detailTransition.value = Event(content = heroId)
    }

    fun atTheEndOfScroll(size: Int) {
        getHeroes(offset = size)
    }

    fun onDestroy() {
        cancelScope()
    }
}