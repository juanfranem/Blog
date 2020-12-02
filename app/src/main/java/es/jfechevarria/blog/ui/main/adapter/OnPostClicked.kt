package es.jfechevarria.blog.ui.main.adapter

import es.jfechevarria.domain.post.Post

interface OnPostClicked {
    fun OnClick(p: Post)
}