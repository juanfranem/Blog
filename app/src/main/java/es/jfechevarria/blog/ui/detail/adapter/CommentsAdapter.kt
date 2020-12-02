package es.jfechevarria.blog.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import es.jfechevarria.blog.components.BaseAdapter
import es.jfechevarria.blog.components.BaseHolder
import es.jfechevarria.blog.databinding.HolderCommentBinding
import es.jfechevarria.blog.ui.detail.holder.CommentsHolder
import es.jfechevarria.domain.comment.Comment


class CommentsAdapter: BaseAdapter<Comment>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder<Comment> {
        return CommentsHolder(HolderCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
}