package raum.muchbeer.cinemaktx.domain.usecase.artist

import raum.muchbeer.cinemaktx.data.model.ArtistModel
import raum.muchbeer.cinemaktx.domain.repository.ArtistRepository

class UpdateArtistUseCase(private val repository: ArtistRepository) {
    suspend fun execute() : List<ArtistModel>? = repository.updateArtist()
}