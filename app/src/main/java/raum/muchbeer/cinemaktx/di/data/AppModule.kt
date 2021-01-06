package raum.muchbeer.cinemaktx.di.data

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import raum.muchbeer.cinemaktx.presentation.CoreApplication
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app : Context) : CoreApplication {
        return app as CoreApplication
    }
}