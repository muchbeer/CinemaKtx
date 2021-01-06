package raum.muchbeer.cinemaktx.di.data

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import raum.muchbeer.cinemaktx.data.api.CinemaRetrofitInstance
import raum.muchbeer.cinemaktx.data.api.CinemaService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideCinemaServices() : CinemaService {
        return CinemaRetrofitInstance().cinemaInstance()
    }

    //Alternative
    @Singleton
    @Provides
    fun provideCinemaRetrofit(baseUrl : String) : Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .baseUrl(baseUrl)
            .build()
    }

/*    @Singleton
    @Provides
    @Named("best_service_key")
    fun provideCinemaRetrofitService(retrofit: Retrofit) : CinemaService {
        return retrofit.create(CinemaService::class.java)
    }*/
}