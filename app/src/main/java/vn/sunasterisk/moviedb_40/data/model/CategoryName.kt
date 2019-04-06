package vn.sunasterisk.moviedb_40.data.model

import androidx.annotation.StringDef

@StringDef(
    CategoryName.TITLE_NOW_PLAYING,
    CategoryName.TITLE_UP_COMING,
    CategoryName.TITLE_TOP_RATE,
    CategoryName.TITLE_POPULAR
)
annotation class CategoryName {
    companion object {
        const val TITLE_NOW_PLAYING = "Now Playing"
        const val TITLE_UP_COMING = "Up Coming"
        const val TITLE_TOP_RATE = "Top Rate"
        const val TITLE_POPULAR = "Popular"
    }
}
