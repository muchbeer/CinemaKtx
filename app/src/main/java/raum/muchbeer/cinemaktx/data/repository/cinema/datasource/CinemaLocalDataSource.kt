package raum.muchbeer.cinemaktx.data.repository.cinema.datasource

import raum.muchbeer.cinemaktx.data.model.CinemaModel

interface CinemaLocalDataSource {
    suspend fun retrieveCinemaFrmDB() : List<CinemaModel>
    suspend fun insertCinemasToDB(cinemas:List<CinemaModel>)
    suspend fun clearAll()

}