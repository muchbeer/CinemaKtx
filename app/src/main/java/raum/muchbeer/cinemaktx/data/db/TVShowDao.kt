package raum.muchbeer.cinemaktx.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import raum.muchbeer.cinemaktx.data.model.TVList
import raum.muchbeer.cinemaktx.data.model.TVModel

//@Dao
interface TVShowDao {

   /* @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTVShowList(tvList: List<TVList>)

    @Query("DELETE FROM tv_table")
    suspend fun deleteAllTVCinema()

    @Query("SELECT * FROM tv_table")
    suspend fun retrieveTVShow(tvShows: List<TVModel>)*/
}