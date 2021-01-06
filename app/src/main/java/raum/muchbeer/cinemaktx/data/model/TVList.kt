package raum.muchbeer.cinemaktx.data.model

import com.google.gson.annotations.SerializedName

data class TVList(

    @SerializedName("results")
    val results: List<TVModel>,
    @SerializedName("total_pages")
    val totalPages: Int,

)