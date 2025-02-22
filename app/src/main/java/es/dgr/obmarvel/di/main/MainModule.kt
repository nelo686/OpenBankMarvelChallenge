package es.dgr.obmarvel.di.main

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import es.dgr.obmarvel.ui.main.HeroListViewModel
import es.dgr.usecases.GetHeroesUseCase

@Module
@InstallIn(ActivityComponent::class)
class MainModule {

    @Provides
    fun heroListViewModelProvider(useCase: GetHeroesUseCase): HeroListViewModel =
        HeroListViewModel(useCase = useCase)
}