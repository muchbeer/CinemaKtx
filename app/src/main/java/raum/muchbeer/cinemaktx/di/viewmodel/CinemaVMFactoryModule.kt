package raum.muchbeer.cinemaktx.di.viewmodel

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import raum.muchbeer.cinemaktx.domain.usecase.cinema.RetrieveCinemasUseCase
import raum.muchbeer.cinemaktx.domain.usecase.cinema.UpdateCinemasUseCase
import raum.muchbeer.cinemaktx.presentation.viewmodel.CinemaViewModelFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class CinemaVMFactoryModule {

    @Singleton
    @Provides
    fun provideCinemaVMFactory(retrieveCMUseCase: RetrieveCinemasUseCase) : CinemaViewModelFactory {
        return CinemaViewModelFactory(retrieveCMUseCase)
    }
}