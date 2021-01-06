package raum.muchbeer.cinemaktx.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import raum.muchbeer.cinemaktx.data.model.*

@Dao
interface CinemaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCinemaList(cinemas : List<CinemaModel>)

    @Query("DELETE FROM cinema_table")
    suspend fun deleteAllCinema()

    @Query("SELECT * FROM cinema_table")
    suspend fun retrieveCinema() : List<CinemaModel>


}