package es.jfechevarria.data.infrastructure.useCase

import es.jfechevarria.data.infrastructure.UseCase
import es.jfechevarria.domain.comment.Comment
import es.jfechevarria.domain.comment.CommentLocalRepository
import es.jfechevarria.domain.comment.CommentRemoteRepository
import es.jfechevarria.domain.post.Post

class GetCommentByPostUseCase(
    private val commentRemoteRepository: CommentRemoteRepository,
    private val commentLocalRepository: CommentLocalRepository
) :UseCase<List<Comment>, GetCommentByPostUseCase.Params>() {

    data class Params(val post: Post)

    override suspend fun execute(params: Params): List<Comment> {
        var response = commentLocalRepository.getByPost(params.post)
        if (response.isEmpty()) {
            commentLocalRepository.saveAll(commentRemoteRepository.get())
            response = commentLocalRepository.getByPost(params.post)
        }
        return response
    }


}