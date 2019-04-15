package vn.sunasterisk.moviedb_40.data.source.remote

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import vn.sunasterisk.moviedb_40.data.model.Actor
import vn.sunasterisk.moviedb_40.data.model.Movie
import vn.sunasterisk.moviedb_40.data.source.remote.response.GenreResponse
import vn.sunasterisk.moviedb_40.data.source.remote.response.MovieResponse

interface ApiRequest {
    @GET("genre/movie/list")
    fun getGenres(): Observable<GenreResponse>

    @GET("trending/movie/day")
    fun getMoviesTrending(): Observable<MovieResponse>

    @GET("movie/{type}")
    fun getMoviesByCategory(
        @Path("type") type: String,
        @Query("page") page: Int
    ): Observable<MovieResponse>

    @GET("discover/movie")
    fun getMoviesByGenre(
        @Query("with_genres") idGenre: String,
        @Query("page") page: Int
    ): Observable<MovieResponse>

    @GET("discover/movie")
    fun getMoviesByActor(
        @Query("with_cast") idCast: String,
        @Query("page") page: Int
    ): Observable<MovieResponse>

    @GET("discover/movie")
    fun getMoviesByCompany(
        @Query("with_companies") idCompany: Int,
        @Query("page") page: Int
    ): Observable<MovieResponse>

    @GET("movie/{movie_id}?append_to_response=credits,videos")
    fun getMovieDetail(@Path("movie_id") id: Int): Observable<Movie>

    @GET("search/movie")
    fun searchMovieByKeyword(
        @Query("query") key: String,
        @Query("page") page: Int
    ): Observable<MovieResponse>

    @GET("person/{actor_id}")
    fun getProfileActor(@Path("actor_id") actorId: String): Observable<Actor>
}
