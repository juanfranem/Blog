package es.jfechevarria.blog.components

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>: RecyclerView.Adapter<BaseHolder<T>>() {

    private val list: MutableList<T> = mutableListOf()

    fun submitList(list: List<T>) {
        this.list.clear()
        this.list.addAll(list)
        this.notifyItemRangeInserted(0, list.size)
    }

    override fun onBindViewHolder(holder: BaseHolder<T>, position: Int) {
        holder.bind(list[holder.adapterPosition])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}