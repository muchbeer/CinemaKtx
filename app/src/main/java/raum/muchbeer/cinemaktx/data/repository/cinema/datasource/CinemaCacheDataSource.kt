package raum.muchbeer.cinemaktx.data.repository.cinema.datasource

import raum.muchbeer.cinemaktx.data.model.CinemaModel

interface CinemaCacheDataSource {

    suspend fun retrieveCinemaFromCache() : List<CinemaModel>
    suspend fun insertCinemaToCache(cinemas:List<CinemaModel>)
}