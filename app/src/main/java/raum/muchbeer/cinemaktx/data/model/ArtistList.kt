package raum.muchbeer.cinemaktx.data.model

import com.google.gson.annotations.SerializedName

data class ArtistList(

    @SerializedName("results")
    val results: List<ArtistModel>,
    @SerializedName("total_results")
    val totalResults: Int
)