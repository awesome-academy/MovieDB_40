package vn.sunasterisk.moviedb_40.data.source.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import vn.sunasterisk.moviedb_40.data.model.Movie

class MovieResponse {
    @SerializedName("page")
    @Expose
    var page: Int = 0

    @SerializedName("total_page")
    @Expose
    var totalPage: Int = 0

    @SerializedName("total_results")
    @Expose
    var totalResult: Int = 0

    @SerializedName("results")
    @Expose
    var results: List<Movie>? = null
}
