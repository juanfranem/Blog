package es.jfechevarria.domain.comment

interface CommentRemoteRepository {
    suspend fun get(): List<Comment>
}