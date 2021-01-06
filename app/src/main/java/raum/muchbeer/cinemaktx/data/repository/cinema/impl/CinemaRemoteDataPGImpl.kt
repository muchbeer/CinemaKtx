package raum.muchbeer.cinemaktx.data.repository.cinema.impl

import android.util.Log
import raum.muchbeer.cinemaktx.BuildConfig
import raum.muchbeer.cinemaktx.data.api.CinemaService
import raum.muchbeer.cinemaktx.data.model.CinemaList
import raum.muchbeer.cinemaktx.data.model.CinemaModel
import raum.muchbeer.cinemaktx.data.repository.cinema.datasource.CinemaRemoteDataPG
import raum.muchbeer.cinemaktx.utility.LoadingStatus
import retrofit2.Call
import retrofit2.Callback

class CinemaRemoteDataPGImpl(private val cinemaService:CinemaService) : CinemaRemoteDataPG {
    override suspend fun fetchMovies(
        onSuccess: (movies: List<CinemaModel>) -> Unit,
        onStatus: (status: LoadingStatus) -> Unit
    ): Call<CinemaList> {
     return  cinemaService.getMovies(BuildConfig.API_KEY)
    }

}