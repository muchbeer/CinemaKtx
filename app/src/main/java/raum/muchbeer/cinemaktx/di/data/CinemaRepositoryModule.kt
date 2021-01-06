package raum.muchbeer.cinemaktx.di.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import raum.muchbeer.cinemaktx.data.repository.cinema.datasource.CinemaCacheDataSource
import raum.muchbeer.cinemaktx.data.repository.cinema.datasource.CinemaLocalDataSource
import raum.muchbeer.cinemaktx.data.repository.cinema.datasource.CinemaRemoteDataSource
import raum.muchbeer.cinemaktx.data.repository.cinema.datasource.CinemaRemotePagingDataSource
import raum.muchbeer.cinemaktx.data.repository.cinema.impl.CinemaRepositoryImpl
import raum.muchbeer.cinemaktx.domain.repository.CinemaRepository
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class CinemaRepositoryModule {

    @Singleton
    @Provides
    fun providesCinemaRepository(cinemaRemoteDS: CinemaRemoteDataSource,
                                 cinemaLocalDS : CinemaLocalDataSource,
                                 cinemaCacheDS: CinemaCacheDataSource) : CinemaRepository {
        return CinemaRepositoryImpl(cinemaRemoteDS,cinemaLocalDS, cinemaCacheDS)
    }


}