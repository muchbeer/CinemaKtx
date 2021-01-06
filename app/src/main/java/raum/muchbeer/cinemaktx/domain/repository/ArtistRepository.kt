package raum.muchbeer.cinemaktx.domain.repository

import raum.muchbeer.cinemaktx.data.model.ArtistModel

interface ArtistRepository {
    suspend fun retrieveArtist() : List<ArtistModel>?
    suspend fun updateArtist() : List<ArtistModel>?
}