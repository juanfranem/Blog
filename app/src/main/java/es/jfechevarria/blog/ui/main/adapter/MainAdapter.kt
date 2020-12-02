package es.jfechevarria.blog.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import es.jfechevarria.blog.components.BaseAdapter
import es.jfechevarria.blog.components.BaseHolder
import es.jfechevarria.blog.databinding.HolderPostBigBinding
import es.jfechevarria.blog.databinding.HolderPostSmallBinding
import es.jfechevarria.blog.ui.main.holder.MainBigHolder
import es.jfechevarria.blog.ui.main.holder.MainSmallHolder
import es.jfechevarria.domain.post.Post

class MainAdapter(
    private val onPostClicked: OnPostClicked
): BaseAdapter<Post>() {

    override fun getItemViewType(position: Int): Int {
        return if (position != 0 && position % 5 == 0) {
            MainBigHolder.viewType
        } else {
            MainSmallHolder.viewType
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder<Post> {
        return when (viewType) {
            MainBigHolder.viewType -> MainBigHolder(HolderPostBigBinding.inflate(
                LayoutInflater.from(parent.context), parent, false),
                onPostClicked)
            else -> MainSmallHolder(HolderPostSmallBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), onPostClicked)
        }
    }

}