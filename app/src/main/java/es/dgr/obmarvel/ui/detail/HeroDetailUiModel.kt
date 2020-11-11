package es.dgr.obmarvel.ui.detail

import es.dgr.domain.entities.Hero

sealed class HeroDetailUiModel {
    object Loading : HeroDetailUiModel()
    class ErrorResponse(val message: String) : HeroDetailUiModel()
    class Content(val hero: Hero) : HeroDetailUiModel()
}
