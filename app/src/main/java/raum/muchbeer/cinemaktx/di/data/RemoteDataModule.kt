package raum.muchbeer.cinemaktx.di.data

import android.content.Context
import android.os.Build
import androidx.databinding.BindingBuildInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import raum.muchbeer.cinemaktx.BuildConfig
import raum.muchbeer.cinemaktx.data.api.CinemaRetrofitInstance
import raum.muchbeer.cinemaktx.data.api.CinemaService
import raum.muchbeer.cinemaktx.data.repository.cinema.datasource.CinemaRemoteDataSource
import raum.muchbeer.cinemaktx.data.repository.cinema.impl.CinemaRemoteDataSourceImpl
import raum.muchbeer.cinemaktx.presentation.CoreApplication
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RemoteDataModule() {

    @Singleton
    @Provides
    fun providesCinemaRemoteDS(cinemaService: CinemaService)
                                                     : CinemaRemoteDataSource {
        return CinemaRemoteDataSourceImpl(cinemaService,  BuildConfig.API_KEY)
    }

/*    @Singleton
    @Provides
    @Named("api_key")
    fun providesApiKeyCinemaService() : String {
        return "e2e2cae1c5b9256b4dc97f8c430165dc"
    }*/
}