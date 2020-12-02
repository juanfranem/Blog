package es.jfechevarria.data.infrastructure.post.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import es.jfechevarria.domain.post.Post

@Entity
class PostLocal(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
) {
    fun toDomain(): Post = Post(this.id, this.title, this.userId, this.body)

    companion object {
        fun fromDomain(post: Post): PostLocal = PostLocal(post.id, post.user, post.title, post.body)
    }
}