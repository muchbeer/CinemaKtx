package raum.muchbeer.cinemaktx.di.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import raum.muchbeer.cinemaktx.data.repository.cinema.datasource.CinemaCacheDataSource
import raum.muchbeer.cinemaktx.data.repository.cinema.impl.CinemaCacheDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class CacheDataModule {

    @Singleton
    @Provides
    fun providesCinemaCacheDS() : CinemaCacheDataSource {
        return CinemaCacheDataSourceImpl()
    }
}