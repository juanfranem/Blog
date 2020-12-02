package es.jfechevarria.blog.ui.main.holder

import es.jfechevarria.blog.components.BaseHolder
import es.jfechevarria.blog.databinding.HolderPostSmallBinding
import es.jfechevarria.blog.ui.main.adapter.OnPostClicked
import es.jfechevarria.domain.post.Post

class MainSmallHolder(private val holderPostSmallBinding: HolderPostSmallBinding,
    private val onPostClicked: OnPostClicked)
    :BaseHolder<Post>(holderPostSmallBinding) {
    override fun bind(t: Post) {
        holderPostSmallBinding.title.text = t.title
        holderPostSmallBinding.root.setOnClickListener {
            onPostClicked.OnClick(t)
        }
    }

    companion object {
        const val viewType: Int = 150
    }

}