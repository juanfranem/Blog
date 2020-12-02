package es.jfechevarria.data.local.repositories

import es.jfechevarria.data.infrastructure.comment.local.CommentLocal
import es.jfechevarria.data.local.config.CommentDao
import es.jfechevarria.domain.comment.Comment
import es.jfechevarria.domain.comment.CommentLocalRepository
import es.jfechevarria.domain.post.Post

class CommentRepositoryImpl(
    private val commentDao: CommentDao
): CommentLocalRepository {
    override suspend fun save(comment: Comment) {
        return commentDao.saveAll(listOf(CommentLocal.fromDomain(comment)))
    }

    override suspend fun saveAll(list: List<Comment>) {
        return commentDao.saveAll(list.map { CommentLocal.fromDomain(it) })
    }

    override suspend fun getByPost(post: Post): List<Comment> {
        return commentDao.findCommentsByPost(post.id).map { it.toDomain() }
    }

}