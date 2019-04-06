package vn.sunasterisk.moviedb_40.data.source.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import vn.sunasterisk.moviedb_40.data.model.Genre

class GenreResponse {
    @SerializedName("genres")
    @Expose
    var genres: List<Genre>? = null
}
