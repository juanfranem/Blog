package es.jfechevarria.data.infrastructure.comment.remote

import es.jfechevarria.domain.comment.Comment


class CommentRemote(
    val postId: Int,
    private val id: Int,
    private val name: String,
    private val email: String,
    private val body: String
) {
    fun toDomain(): Comment = Comment(this.id, this.postId, this.name, this.email, this.body)
}