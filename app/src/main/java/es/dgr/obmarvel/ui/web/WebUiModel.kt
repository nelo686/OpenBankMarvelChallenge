package es.dgr.obmarvel.ui.web

sealed class WebUiModel() {
    object Loading : WebUiModel()
    class Load(val url: String): WebUiModel()
}