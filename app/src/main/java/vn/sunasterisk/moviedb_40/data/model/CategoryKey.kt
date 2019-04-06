package vn.sunasterisk.moviedb_40.data.model

import androidx.annotation.StringDef

@StringDef(
    CategoryKey.CATEGORY_POPULAR,
    CategoryKey.CATEGORY_NOW_PLAYING,
    CategoryKey.CATEGORY_UP_COMING,
    CategoryKey.CATEGORY_TOP_RATE
)
annotation class CategoryKey {
    companion object {
        const val CATEGORY_POPULAR = "popular"
        const val CATEGORY_NOW_PLAYING = "now_playing"
        const val CATEGORY_UP_COMING = "upcoming"
        const val CATEGORY_TOP_RATE = "top_rated"
    }
}
