package es.dgr.obmarvel.di.detail

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import es.dgr.obmarvel.ui.detail.HeroDetailViewModel
import es.dgr.usecases.GetHeroDetailsUseCase

@Module
@InstallIn(ActivityComponent::class)
class DetailModule {

    @Provides
    fun heroDetailViewModelProvider(useCase: GetHeroDetailsUseCase): HeroDetailViewModel =
        HeroDetailViewModel(useCase = useCase)
}