package vn.sunasterisk.moviedb_40.base

import androidx.recyclerview.widget.RecyclerView
import vn.sunasterisk.moviedb_40.utils.Constants

abstract class BaseRecyclerViewAdapter<T, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {
    var listData: MutableList<T>
    lateinit var listener: ItemListener<T>

    var data: List<T>?
        get() = listData
        set(data) {
            if (data != null) {
                listData.clear()
                listData.addAll(data)
                notifyDataSetChanged()
            }
        }

    init {
        listData = ArrayList()
    }

    fun setItemListener(listener: ItemListener<T>?) {
        if (listener != null)
            this.listener = listener
    }

    fun addData(data: List<T>?) {
        if (data != null) {
            val startPosition = data.size
            listData.addAll(data)
            notifyItemRangeChanged(startPosition, data.size - Constants.OFFSET_LIST)
        }
    }

    fun addData(data: T?) {
        if (data != null) {
            listData.add(data)
            notifyItemInserted(listData.size - 1)
        }
    }

    fun addItem(t: T) {
        listData.add(t)
        notifyItemInserted(listData.size - 1)
    }

    fun removeItem(position: Int) {
        listData.removeAt(position)
        notifyItemRemoved(position)
    }

    interface ItemListener<T> {
        fun onItemClicked(t: T, position: Int)
        fun onElementClicked(t: T, position: Int)
    }
}
