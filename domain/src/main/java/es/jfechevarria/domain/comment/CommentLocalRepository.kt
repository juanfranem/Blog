package es.jfechevarria.domain.comment

import es.jfechevarria.domain.post.Post

interface CommentLocalRepository {
    suspend fun save(comment: Comment)
    suspend fun saveAll(list: List<Comment>)
    suspend fun getByPost(post: Post): List<Comment>
}