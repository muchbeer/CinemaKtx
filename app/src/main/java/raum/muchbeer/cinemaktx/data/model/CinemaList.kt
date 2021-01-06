package raum.muchbeer.cinemaktx.data.model


import com.google.gson.annotations.SerializedName

data class CinemaList(

    @SerializedName("results")
    val results: List<CinemaModel>,
    @SerializedName("total_pages")
    val totalPages: Int,

)