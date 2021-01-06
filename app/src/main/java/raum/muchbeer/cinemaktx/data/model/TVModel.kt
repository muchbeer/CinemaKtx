package raum.muchbeer.cinemaktx.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tv_table")
data class TVModel(

    @ColumnInfo(name = "firstAirDate")
    @SerializedName("first_air_date")
    val firstAirDate: String?=null,
    @PrimaryKey
    @SerializedName("id")
    val id: Int?=null,
    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name: String,
    @ColumnInfo(name = "overview")
    @SerializedName("overview")
    val overview: String,
    @ColumnInfo(name = "posterPath")
    @SerializedName("poster_path")
    val posterPath: String

) {
constructor() : this("", 0, "", "", "")
}