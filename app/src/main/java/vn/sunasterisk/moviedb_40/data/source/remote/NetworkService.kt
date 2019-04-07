package vn.sunasterisk.moviedb_40.data.source.remote

import android.content.Context
import vn.sunasterisk.moviedb_40.data.source.remote.response.RetrofitBuilder

class NetworkService {
    companion object {
        var apiRequest: ApiRequest? = null
        fun getInstance(context: Context): ApiRequest? {
            if (apiRequest == null) {
                apiRequest = RetrofitBuilder.getInstance(context)?.create(ApiRequest::class.java)
            }
            return apiRequest
        }
    }
}
