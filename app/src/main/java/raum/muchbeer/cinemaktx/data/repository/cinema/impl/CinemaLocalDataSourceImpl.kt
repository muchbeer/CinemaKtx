package raum.muchbeer.cinemaktx.data.repository.cinema.impl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import raum.muchbeer.cinemaktx.data.db.CinemaDao
import raum.muchbeer.cinemaktx.data.model.CinemaModel
import raum.muchbeer.cinemaktx.data.repository.cinema.datasource.CinemaLocalDataSource

class CinemaLocalDataSourceImpl(private val cinemaDao : CinemaDao) : CinemaLocalDataSource {

    override suspend fun retrieveCinemaFrmDB(): List<CinemaModel> {
       return cinemaDao.retrieveCinema()
    }

    override suspend fun insertCinemasToDB(cinemas: List<CinemaModel>) {
        CoroutineScope(Dispatchers.IO).launch {
            cinemaDao.insertCinemaList(cinemas)
        }

    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            cinemaDao.deleteAllCinema()
        }

    }


}