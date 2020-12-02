package es.jfechevarria.blog.ui.main.holder

import es.jfechevarria.blog.components.BaseHolder
import es.jfechevarria.blog.databinding.HolderPostBigBinding
import es.jfechevarria.blog.ui.main.adapter.OnPostClicked
import es.jfechevarria.domain.post.Post

class MainBigHolder(private val holderPostBigBinding: HolderPostBigBinding,
    private val onPostClicked: OnPostClicked)
    : BaseHolder<Post>(holderPostBigBinding) {
    override fun bind(t: Post) {
        holderPostBigBinding.title.text = t.title
        holderPostBigBinding.body.text = t.body
        holderPostBigBinding.root.setOnClickListener {
            onPostClicked.OnClick(t)
        }
    }

    companion object {
        const val viewType: Int = 100
    }

}