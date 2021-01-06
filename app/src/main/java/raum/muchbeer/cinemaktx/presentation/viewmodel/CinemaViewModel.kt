package raum.muchbeer.cinemaktx.presentation.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.ExperimentalCoroutinesApi
import raum.muchbeer.cinemaktx.data.model.CinemaModel
import raum.muchbeer.cinemaktx.domain.usecase.cinema.RetrieveCinemasUseCase
import raum.muchbeer.cinemaktx.domain.usecase.cinema.UpdateCinemasUseCase

@ExperimentalCoroutinesApi
class CinemaViewModel
    @ViewModelInject
    constructor(
        private val retrieveCinema: RetrieveCinemasUseCase,
      ) : ViewModel() {

          fun retrieveCinemaMovie() = liveData {
              val emitCinemaList = retrieveCinema.execute()
              emit(emitCinemaList)
          }
       /*  fun retrieveCinemaMovie() : LiveData<List<CinemaModel>> {
              val response :LiveData<List<CinemaModel>> = liveData {
                  val emitCinemaList = retrieveCinema.execute()
                  emitCinemaList?.let { emit(it) }
              }
Log.d("CinameViewModel", "The list of Moview : ${response}")
              return response
          }*/

}