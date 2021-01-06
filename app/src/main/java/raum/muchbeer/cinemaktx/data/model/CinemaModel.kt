package raum.muchbeer.cinemaktx.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "cinema_table")
data class CinemaModel(

    @PrimaryKey
    @SerializedName("id")
    val id: Int?=null,
    @ColumnInfo(name = "overview")
    @SerializedName("overview")
    val overview: String,
    @ColumnInfo(name = "posterPath")
    @SerializedName("poster_path")
    val posterPath: String,
    @ColumnInfo(name = "releaseDate")
    @SerializedName("release_date")
    val releaseDate: String,
    @ColumnInfo(name = "title")
    @SerializedName("title")
    val title: String

) {
constructor() : this(0,"","","","")
}