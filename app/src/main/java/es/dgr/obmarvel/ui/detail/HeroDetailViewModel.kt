package es.dgr.obmarvel.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.dgr.obmarvel.ui.common.Event
import es.dgr.obmarvel.ui.common.Scope
import es.dgr.obmarvel.ui.common.message
import es.dgr.usecases.GetHeroDetailsUseCase
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HeroDetailViewModel @ViewModelInject constructor(
    private val useCase: GetHeroDetailsUseCase
) : ViewModel(), Scope by Scope.Impl() {

    private val _model = MutableLiveData<HeroDetailUiModel>()
    val model: LiveData<HeroDetailUiModel>
        get() = _model

    private val _webTransition = MutableLiveData<Event<String>>()
    val webTransition: LiveData<Event<String>>
        get() = _webTransition

    init {
        initScope()
    }

    fun onViewCreated(heroId: Int) {
        getHeroDetails(heroId = heroId)
    }

    private fun getHeroDetails(heroId: Int) {
        launch {
            _model.value = HeroDetailUiModel.Loading
            withContext(ioDispatcher) {
                useCase.execute(heroId = heroId)
            }.fold(
                { _model.value = HeroDetailUiModel.ErrorResponse(it.message()) },
                { _model.value = HeroDetailUiModel.Content(hero = it) }
            )
        }
    }

    fun onItemClicked(url: String) {
        _webTransition.value = Event(content = url)
    }

    fun onDestroy() {
        cancelScope()
    }
}