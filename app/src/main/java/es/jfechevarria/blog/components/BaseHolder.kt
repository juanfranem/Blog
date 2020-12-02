package es.jfechevarria.blog.components

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseHolder<T>(v: ViewBinding): RecyclerView.ViewHolder(v.root) {
    abstract fun bind(t: T)
}