package es.jfechevarria.data.infrastructure.post.remote

import es.jfechevarria.domain.comment.Comment
import es.jfechevarria.domain.post.Post
import es.jfechevarria.domain.user.User

class PostRemote(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
) {
    fun toDomain(): Post = Post(this.id, this.title, this.userId, this.body)
}