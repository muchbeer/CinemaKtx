package raum.muchbeer.cinemaktx.domain.repository

import raum.muchbeer.cinemaktx.data.model.CinemaModel

interface CinemaRepository {
    suspend fun retrieveCinemaMoview() : List<CinemaModel>?

}