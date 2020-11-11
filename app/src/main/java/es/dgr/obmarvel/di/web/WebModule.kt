package es.dgr.obmarvel.di.web

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import es.dgr.obmarvel.ui.web.WebViewModel

@Module
@InstallIn(ActivityComponent::class)
class WebModule {

    @Provides
    fun webViewModelProvider(): WebViewModel = WebViewModel()
}