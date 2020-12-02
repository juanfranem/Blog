package es.jfechevarria.data.infrastructure.comment.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import es.jfechevarria.domain.comment.Comment
import es.jfechevarria.domain.post.Post

@Entity
class CommentLocal(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val postId: Int,
    val name: String,
    val email: String,
    val body: String
) {
    fun toDomain(): Comment = Comment(this.id, this.postId, this.name, this.email, this.body)

    companion object {
        fun fromDomain(comment: Comment): CommentLocal = CommentLocal(comment.id, comment.post, comment.name, comment.email, comment.body)
    }
}