package raum.muchbeer.cinemaktx.di.data

import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import raum.muchbeer.cinemaktx.data.db.CinemaDao
import raum.muchbeer.cinemaktx.data.db.CinemaGeneralDatabase
import raum.muchbeer.cinemaktx.presentation.CoreApplication
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    @Named("database_key")
    fun providesCinemaDatabase(applictionContext : CoreApplication) : CinemaGeneralDatabase {
            return Room.databaseBuilder(applictionContext.applicationContext,
                         CinemaGeneralDatabase::class.java,
                            "gadiel_cinema").build()
    }

    @Singleton
    @Provides
    fun providesCinemaDatabaseBest(applictionContext: CoreApplication) : CinemaGeneralDatabase {
        return CinemaGeneralDatabase.getCinemaDatabaseInstance(applictionContext.applicationContext)
    }

    @Singleton
    @Provides
    fun providesCinemaDao(cinemaDB: CinemaGeneralDatabase) : CinemaDao{
        return cinemaDB.CinemaDao()
    }
}