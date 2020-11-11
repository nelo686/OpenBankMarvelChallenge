package es.dgr.obmarvel.ui.detail

sealed class SummaryType {
    object ComicsSummaryType : SummaryType()
    object SeriesSummaryType : SummaryType()
    object StoriesSummaryType : SummaryType()
    object EventsSummaryType : SummaryType()
    object UrlsSummaryType : SummaryType()
}
