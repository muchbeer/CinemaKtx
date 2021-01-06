package raum.muchbeer.cinemaktx.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import raum.muchbeer.cinemaktx.domain.repository.CinemaRepository
import raum.muchbeer.cinemaktx.domain.usecase.cinema.RetrieveCinemasUseCase
import raum.muchbeer.cinemaktx.domain.usecase.cinema.UpdateCinemasUseCase
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun providesRetrieveUseCase(repository: CinemaRepository) : RetrieveCinemasUseCase {
        return RetrieveCinemasUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideUpdateCinemaUseCase(repository: CinemaRepository) : UpdateCinemasUseCase {
        return UpdateCinemasUseCase(repository)
    }
}