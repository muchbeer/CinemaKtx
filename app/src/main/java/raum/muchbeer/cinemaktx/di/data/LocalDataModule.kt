package raum.muchbeer.cinemaktx.di.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import raum.muchbeer.cinemaktx.data.db.CinemaDao
import raum.muchbeer.cinemaktx.data.repository.cinema.datasource.CinemaLocalDataSource
import raum.muchbeer.cinemaktx.data.repository.cinema.impl.CinemaLocalDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class LocalDataModule {

    @Singleton
    @Provides
    fun providesLocalDataSource(cinemaDao: CinemaDao) : CinemaLocalDataSource {
        return CinemaLocalDataSourceImpl(cinemaDao)
    }
}