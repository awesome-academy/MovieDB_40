package vn.sunasterisk.moviedb_40.data.source.remote.response

import android.content.Context
import android.net.ConnectivityManager
import okhttp3.Cache
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import vn.sunasterisk.moviedb_40.BuildConfig
import java.util.concurrent.TimeUnit

class RetrofitBuilder private constructor() {
    companion object {
        const val QUERY_PARAMETER_API_KEY: String = "api_key"
        const val API_KEY = BuildConfig.ApiKey
        const val CACHE_SIZE = 10 * 1024 * 1024
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val READ_TIMEOUT = 10000
        const val WRITE_TIMEOUT = 10000
        const val CONNECT_TIMEOUT = 10000
        const val TIME_CACHE_ONLINE = "public, max-age = 60"
        const val TIME_CACHE_OFFLINE = "public, only-if-cached, max-stale = 86400"
        const val CACHE_CONTROL = "Cache-Control"
        var retrofit: Retrofit? = null

        fun getInstance(context: Context): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(initClient(context))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }

        fun initClient(context: Context): OkHttpClient {
            val builder = OkHttpClient.Builder()
                .readTimeout(READ_TIMEOUT.toLong(), TimeUnit.MILLISECONDS)
                .writeTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.MILLISECONDS)
                .connectTimeout(CONNECT_TIMEOUT.toLong(), TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true)
                .cache(Cache(context.cacheDir, CACHE_SIZE.toLong()))
                .addInterceptor(Interceptor { chain: Interceptor.Chain -> makeResponse(chain, context) })
            return builder.build()
        }

        fun isNetworkAvailable(context: Context): Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
                    as ConnectivityManager
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            return activeNetworkInfo != null && activeNetworkInfo.isConnected
        }

        fun makeResponse(chain: Interceptor.Chain, context: Context): okhttp3.Response {
            val request = chain.request().newBuilder()
                .header(
                    CACHE_CONTROL,
                    if (isNetworkAvailable(context)) TIME_CACHE_ONLINE else TIME_CACHE_OFFLINE
                )
                .build()
            val httpUrl: HttpUrl = request.url().newBuilder()
                .addQueryParameter(QUERY_PARAMETER_API_KEY, API_KEY).build()
            val requestBuilder = request.newBuilder().url(httpUrl)
            return chain.proceed(requestBuilder.build())
        }
    }
}
