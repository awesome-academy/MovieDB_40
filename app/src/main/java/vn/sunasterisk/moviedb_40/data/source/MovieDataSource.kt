package vn.sunasterisk.moviedb_40.data.source

import androidx.databinding.ObservableArrayList
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import vn.sunasterisk.moviedb_40.data.model.Actor
import vn.sunasterisk.moviedb_40.data.model.Movie
import vn.sunasterisk.moviedb_40.data.source.remote.response.GenreResponse
import vn.sunasterisk.moviedb_40.data.source.remote.response.MovieResponse

interface MovieDataSource {
    interface Local {
        val allFavorite: ObservableArrayList<Movie>

        fun addFavorite(movie: Movie): Completable

        fun deleteFavorite(movie: Movie): Completable

        fun isFavorite(movieId: Int): Single<Boolean>
    }

    interface Remote {
        fun getGenres(): Observable<GenreResponse>

        fun getMoviesTrending(): Observable<MovieResponse>

        fun getMoviesByCategory(categoryType: String, page: Int): Observable<MovieResponse>

        fun getMoviesByGenre(idGenre: String, page: Int): Observable<MovieResponse>

        fun getMoviesByActor(idActor: String, page: Int): Observable<MovieResponse>

        fun getMoviesByCompany(idCompany: Int, page: Int): Observable<MovieResponse>

        fun getMovieDetail(idMovie: Int): Observable<Movie>

        fun searchMovieByKeyword(key: String, page: Int): Observable<MovieResponse>

        fun getProfileActor(actorId: String): Observable<Actor>
    }
}
