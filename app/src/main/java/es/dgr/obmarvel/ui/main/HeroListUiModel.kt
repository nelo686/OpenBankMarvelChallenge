package es.dgr.obmarvel.ui.main

import es.dgr.domain.entities.Hero

sealed class HeroListUiModel {
    object Loading : HeroListUiModel()
    class ErrorResponse(val message: String) : HeroListUiModel()
    class Content(val heroes: List<Hero>) : HeroListUiModel()
}
