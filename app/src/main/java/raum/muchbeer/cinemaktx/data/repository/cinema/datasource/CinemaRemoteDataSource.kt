package raum.muchbeer.cinemaktx.data.repository.cinema.datasource

import raum.muchbeer.cinemaktx.data.model.CinemaList
import raum.muchbeer.cinemaktx.data.model.CinemaModel
import retrofit2.Response

interface CinemaRemoteDataSource {
    suspend fun retrieveCinemaRemote() : Response<CinemaList>
}