package raum.muchbeer.cinemaktx.data.api

import raum.muchbeer.cinemaktx.data.model.ArtistList
import raum.muchbeer.cinemaktx.data.model.CinemaList
import raum.muchbeer.cinemaktx.data.model.TVList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CinemaService {

    //since we use coroutine then we need to use Suspend
    @GET("movie/popular")
    suspend fun getDopeMovies(@Query("api_key")apiKey:String,  @Query("page") page: Int) : Response<CinemaList>

    @GET("movie/popular")
    suspend fun getMoviesTrial(@Query("api_key")apiKey:String) : Response<CinemaList>


    @GET("tv/popular")
    suspend fun getDopeTVShow(@Query("api_key") apiKey: String) : Response<TVList>

    @GET("person/popular")
    suspend fun getDopeActs(@Query("api_key") apiKey: String) : Response<ArtistList>


     @GET("movie/popular")
    suspend fun getMovies(@Query("api_key")apiKey:String) : Call<CinemaList>

}