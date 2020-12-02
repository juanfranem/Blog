package es.jfechevarria.blog.ui.detail.holder

import es.jfechevarria.blog.components.BaseHolder
import es.jfechevarria.blog.databinding.HolderCommentBinding
import es.jfechevarria.domain.comment.Comment

class CommentsHolder(private val holderCommentBinding: HolderCommentBinding): BaseHolder<Comment>(holderCommentBinding) {
    override fun bind(t: Comment) {
        holderCommentBinding.title.text = t.name
        holderCommentBinding.body.text = t.body
        holderCommentBinding.autor.text = t.email
    }
}