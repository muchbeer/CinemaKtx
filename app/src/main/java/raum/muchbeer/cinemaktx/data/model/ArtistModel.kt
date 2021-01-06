package raum.muchbeer.cinemaktx.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "artist_table")
data class ArtistModel(

    @PrimaryKey
    @SerializedName("id")
    val id: Int?=null,

    @ColumnInfo(name = "knownForDepartment")
    @SerializedName("known_for_department")
    val knownForDepartment: String,

    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name: String,

    @ColumnInfo(name = "profilePath")
    @SerializedName("profile_path")
    val profilePath: String
    ){
    constructor(): this(0, "","","")
}