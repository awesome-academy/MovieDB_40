package vn.sunasterisk.moviedb_40.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Movie {
    @SerializedName("id")
    @Expose
    var id: Int = 0

    @SerializedName("backdrop_path")
    @Expose
    var backdropPath: String? = null

    @SerializedName("genres")
    @Expose
    var genres: List<Genre>? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("overview")
    @Expose
    var overview: String? = null

    @SerializedName("poster_path")
    @Expose
    var posterPath: String? = null

    @SerializedName("production_companies")
    @Expose
    var productionCompanies: List<Company>? = null

    @SerializedName("release_date")
    @Expose
    var releaseDate: String? = null

    @SerializedName("runtime")
    @Expose
    var runtime: Int = 0

    @SerializedName("vote_average")
    @Expose
    var voteAverage: Double = 0.toDouble()
}
