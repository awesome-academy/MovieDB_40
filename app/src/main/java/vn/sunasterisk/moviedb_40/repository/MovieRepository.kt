package vn.sunasterisk.moviedb_40.repository

import androidx.databinding.ObservableArrayList
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import vn.sunasterisk.moviedb_40.data.model.Actor
import vn.sunasterisk.moviedb_40.data.model.Movie
import vn.sunasterisk.moviedb_40.data.source.MovieDataSource
import vn.sunasterisk.moviedb_40.data.source.local.MovieLocalDataSource
import vn.sunasterisk.moviedb_40.data.source.remote.MovieRemoteDataSource
import vn.sunasterisk.moviedb_40.data.source.remote.response.GenreResponse
import vn.sunasterisk.moviedb_40.data.source.remote.response.MovieResponse

class MovieRepository private constructor(
    val remote: MovieRemoteDataSource,
    val local: MovieLocalDataSource
) : MovieDataSource.Local, MovieDataSource.Remote {

    override val allFavorite: ObservableArrayList<Movie>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun addFavorite(movie: Movie): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteFavorite(movie: Movie): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isFavorite(movieId: Int): Single<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getGenres(): Observable<GenreResponse> {
        return remote.getGenres()
    }

    override fun getMoviesTrending(): Observable<MovieResponse> {
        return remote.getMoviesTrending()
    }

    override fun getMoviesByCategory(categoryType: String, page: Int): Observable<MovieResponse> {
        return remote.getMoviesByCategory(categoryType, page)
    }

    override fun getMoviesByGenre(idGenre: String, page: Int): Observable<MovieResponse> {
        return remote.getMoviesByGenre(idGenre, page)
    }

    override fun getMoviesByActor(idActor: String, page: Int): Observable<MovieResponse> {
        return remote.getMoviesByActor(idActor, page)
    }

    override fun getMoviesByCompany(idCompany: Int, page: Int): Observable<MovieResponse> {
        return remote.getMoviesByCompany(idCompany, page)
    }

    override fun getMovieDetail(idMovie: Int): Observable<Movie> {
        return remote.getMovieDetail(idMovie)
    }

    override fun searchMovieByKeyword(key: String, page: Int): Observable<MovieResponse> {
        return remote.searchMovieByKeyword(key, page)
    }

    override fun getProfileActor(actorId: String): Observable<Actor> {
        return remote.getProfileActor(actorId)
    }
}
