package raum.muchbeer.cinemaktx.data.repository.cinema.impl

import android.util.Log
import raum.muchbeer.cinemaktx.data.model.CinemaModel
import raum.muchbeer.cinemaktx.data.repository.cinema.datasource.CinemaCacheDataSource
import raum.muchbeer.cinemaktx.data.repository.cinema.datasource.CinemaLocalDataSource
import raum.muchbeer.cinemaktx.data.repository.cinema.datasource.CinemaRemoteDataSource
import raum.muchbeer.cinemaktx.domain.repository.CinemaRepository
import java.lang.Exception

class CinemaRepositoryImpl (
    private val cinemaRemoteDataSource: CinemaRemoteDataSource,
    private val cinemaLocalDataSource: CinemaLocalDataSource,
    private val cinemaCacheDataSource: CinemaCacheDataSource
        ) : CinemaRepository {
    override suspend fun retrieveCinemaMoview(): List<CinemaModel>{
        return retrieveCinemaFromAPI()
    }


    suspend fun retrieveCinemaFromAPI() : List<CinemaModel> {
        lateinit var listOfMoview : List<CinemaModel>

        try {
        val response = cinemaRemoteDataSource.retrieveCinemaRemote().body()
            if (response!=null) {
                listOfMoview = response.results
                Log.i("CinemaRepositoryImpl", "ServerRetrieves : ${listOfMoview}")
                cinemaLocalDataSource.insertCinemasToDB(listOfMoview)
            }
        } catch (e: Exception) {
        Log.i("CinemaRepositoryImpl", "The error given is : ${e.message}")
        }
            Log.d("LocalDatabase","Return data from database: ${cinemaLocalDataSource.retrieveCinemaFrmDB()}")
        return listOfMoview
    }

    suspend fun retrieveCinemaFromDB() : List<CinemaModel> {

        lateinit var listOfMoview : List<CinemaModel>
        try {
        listOfMoview = cinemaLocalDataSource.retrieveCinemaFrmDB()
        }catch (e: Exception) {
            Log.i("CinemaRepositoryImpl","The error is : ${e.message}")
        }

        if (listOfMoview!=null) {
            return listOfMoview
        } else {
            listOfMoview = retrieveCinemaFromAPI()

        }

        return listOfMoview
    }

    suspend fun retrieveFromCache() : List<CinemaModel> {
     //   retrieveCinemaFromAPI()
        lateinit var listOfMoview : List<CinemaModel>
        try {
            listOfMoview = cinemaCacheDataSource.retrieveCinemaFromCache()
        }catch (e: Exception) {
            Log.i("CinemaRepositoryImpl","The error is : ${e.message}")
        }

        if (listOfMoview!=null) {
            return listOfMoview
        } else {
            listOfMoview = retrieveCinemaFromDB()
            cinemaCacheDataSource.insertCinemaToCache(listOfMoview)
        }

        return listOfMoview
    }
}