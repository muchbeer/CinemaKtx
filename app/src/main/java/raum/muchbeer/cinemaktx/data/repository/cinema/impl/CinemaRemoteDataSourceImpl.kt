package raum.muchbeer.cinemaktx.data.repository.cinema.impl

import raum.muchbeer.cinemaktx.data.api.CinemaRetrofitInstance
import raum.muchbeer.cinemaktx.data.api.CinemaService
import raum.muchbeer.cinemaktx.data.model.CinemaList
import raum.muchbeer.cinemaktx.data.repository.cinema.datasource.CinemaRemoteDataSource
import retrofit2.Response

class CinemaRemoteDataSourceImpl(private val cinemaService : CinemaService,
                                 private val apiKey: String)
                                                       : CinemaRemoteDataSource {
    override suspend fun retrieveCinemaRemote(): Response<CinemaList> {
        return  cinemaService.getMoviesTrial(apiKey)
    }
}