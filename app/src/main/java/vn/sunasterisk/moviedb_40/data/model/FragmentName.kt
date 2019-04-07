package vn.sunasterisk.moviedb_40.data.model

import androidx.annotation.IntDef

@IntDef(
    FragmentName.HOME,
    FragmentName.CATEGORY,
    FragmentName.FAVORITE
)
annotation class FragmentName {
    companion object {
        const val HOME = 0
        const val CATEGORY = 1
        const val FAVORITE = 2
    }
}
