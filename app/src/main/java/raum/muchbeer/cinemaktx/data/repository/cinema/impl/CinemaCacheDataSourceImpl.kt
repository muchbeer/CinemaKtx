package raum.muchbeer.cinemaktx.data.repository.cinema.impl

import raum.muchbeer.cinemaktx.data.model.CinemaModel
import raum.muchbeer.cinemaktx.data.repository.cinema.datasource.CinemaCacheDataSource

class CinemaCacheDataSourceImpl() : CinemaCacheDataSource {

    private var cinemaList = ArrayList<CinemaModel>()
    override suspend fun retrieveCinemaFromCache(): List<CinemaModel> {
       return cinemaList
    }

    override suspend fun insertCinemaToCache(cinemas: List<CinemaModel>) {
       cinemaList.clear()
        cinemaList = ArrayList(cinemas)
    }
}