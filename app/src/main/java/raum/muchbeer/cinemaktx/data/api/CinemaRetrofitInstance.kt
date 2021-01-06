package raum.muchbeer.cinemaktx.data.api

import android.util.Log
import com.google.gson.GsonBuilder
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class CinemaRetrofitInstance {

    companion object {

        val BASE_URL = "https://api.themoviedb.org/3/"

        val httpLogger = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY }

        val client = OkHttpClient.Builder().apply {
            this.addInterceptor(httpLogger)
                .connectTimeout(30, TimeUnit.SECONDS) }.build()
        }

    fun cinemaInstance() : CinemaService {
        Log.i("RetrofitInstance", "The application has access the CinemaService")
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
                .create(CinemaService::class.java)
    }
}