package vn.sunasterisk.moviedb_40.data.source.remote

import android.content.Context
import io.reactivex.Observable
import vn.sunasterisk.moviedb_40.data.model.Actor
import vn.sunasterisk.moviedb_40.data.model.Movie
import vn.sunasterisk.moviedb_40.data.source.MovieDataSource
import vn.sunasterisk.moviedb_40.data.source.remote.response.GenreResponse
import vn.sunasterisk.moviedb_40.data.source.remote.response.MovieResponse

class MovieRemoteDataSource private constructor(val apiRequest: ApiRequest) : MovieDataSource.Remote {

    companion object {
        var movieRemoteDatSource: MovieRemoteDataSource? = null

        fun getInstance(context: Context): MovieRemoteDataSource? {
            if (movieRemoteDatSource == null) {
                movieRemoteDatSource = MovieRemoteDataSource(NetworkService.getInstance(context)!!)
            }
            return movieRemoteDatSource
        }
    }

    override fun getMoviesTrending(): Observable<MovieResponse> {
        return apiRequest.getMoviesTrending()
    }

    override fun getGenres(): Observable<GenreResponse> {
        return apiRequest.getGenres()
    }

    override fun getMoviesByCategory(categoryType: String, page: Int): Observable<MovieResponse> {
        return apiRequest.getMoviesByCategory(categoryType, page)
    }

    override fun getMoviesByGenre(idGenre: String, page: Int): Observable<MovieResponse> {
        return apiRequest.getMoviesByGenre(idGenre, page)
    }

    override fun getMoviesByActor(idActor: String, page: Int): Observable<MovieResponse> {
        return apiRequest.getMoviesByActor(idActor, page)
    }

    override fun getMoviesByCompany(idCompany: Int, page: Int): Observable<MovieResponse> {
        return apiRequest.getMoviesByCompany(idCompany, page)
    }

    override fun getMovieDetail(idMovie: Int): Observable<Movie> {
        return apiRequest.getMovieDetail(idMovie)
    }

    override fun searchMovieByKeyword(key: String, page: Int): Observable<MovieResponse> {
        return apiRequest.searchMovieByKeyword(key, page)
    }

    override fun getProfileActor(actorId: String): Observable<Actor> {
        return apiRequest.getProfileActor(actorId)
    }
}
