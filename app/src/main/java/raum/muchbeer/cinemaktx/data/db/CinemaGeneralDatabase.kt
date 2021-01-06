package raum.muchbeer.cinemaktx.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import raum.muchbeer.cinemaktx.data.model.ArtistModel
import raum.muchbeer.cinemaktx.data.model.CinemaModel
import raum.muchbeer.cinemaktx.data.model.TVModel

@Database(entities = [CinemaModel::class, TVModel::class, ArtistModel::class],
            version = 4, exportSchema = false)
abstract class CinemaGeneralDatabase : RoomDatabase() {

    abstract fun CinemaDao() : CinemaDao
   // abstract fun TVShowDao() : TVShowDao
  //  abstract fun ArtistDao() : ArtistDao

    companion object {
        private var INSTANCE : CinemaGeneralDatabase? = null

      fun getCinemaDatabaseInstance(context: Context) : CinemaGeneralDatabase
      {
          var instance = INSTANCE
          if(instance ==null) {
              instance = Room.databaseBuilder(
                  context.applicationContext,
                  CinemaGeneralDatabase::class.java,
              "muchbeer_cinema")
                  .fallbackToDestructiveMigration()
                  .build()
          }
          return instance
      }    }
}