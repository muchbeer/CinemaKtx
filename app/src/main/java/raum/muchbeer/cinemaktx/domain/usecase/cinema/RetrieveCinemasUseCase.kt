package raum.muchbeer.cinemaktx.domain.usecase.cinema

import raum.muchbeer.cinemaktx.data.model.CinemaModel
import raum.muchbeer.cinemaktx.domain.repository.CinemaRepository

class RetrieveCinemasUseCase(private val repository: CinemaRepository) {
    suspend fun execute() : List<CinemaModel>? = repository.retrieveCinemaMoview()
}