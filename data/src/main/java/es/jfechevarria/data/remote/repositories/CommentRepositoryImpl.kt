package es.jfechevarria.data.remote.repositories

import es.jfechevarria.data.remote.config.Api
import es.jfechevarria.domain.comment.Comment
import es.jfechevarria.domain.comment.CommentRemoteRepository

class CommentRepositoryImpl(
    private val api: Api
): CommentRemoteRepository {
    override suspend fun get(): List<Comment> {
        return api.comments().map { it.toDomain() }
    }
}