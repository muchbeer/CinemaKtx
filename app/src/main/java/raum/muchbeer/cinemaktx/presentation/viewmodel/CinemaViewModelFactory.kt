package raum.muchbeer.cinemaktx.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import raum.muchbeer.cinemaktx.domain.usecase.cinema.RetrieveCinemasUseCase
import raum.muchbeer.cinemaktx.domain.usecase.cinema.UpdateCinemasUseCase

class CinemaViewModelFactory(private val retrieveCinemasUseCase: RetrieveCinemasUseCase) :
      ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return CinemaViewModel(retrieveCinemasUseCase) as T
    }
}