package vn.sunasterisk.moviedb_40.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Company {
    @SerializedName("id")
    @Expose
    var id: Int = 0

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("logo_path")
    @Expose
    var logoPath: String? = null

    @SerializedName("origin_country")
    @Expose
    var country: String? = null
}
