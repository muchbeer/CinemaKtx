package raum.muchbeer.cinemaktx.data.repository.cinema.datasource

import raum.muchbeer.cinemaktx.data.model.CinemaList
import raum.muchbeer.cinemaktx.data.model.CinemaModel
import raum.muchbeer.cinemaktx.utility.LoadingStatus
import retrofit2.Call
import retrofit2.Callback

interface CinemaRemoteDataPG {

  suspend fun fetchMovies(
        onSuccess: (movies : List<CinemaModel>) -> Unit,
        onStatus: (status : LoadingStatus) -> Unit) : Call<CinemaList>

}