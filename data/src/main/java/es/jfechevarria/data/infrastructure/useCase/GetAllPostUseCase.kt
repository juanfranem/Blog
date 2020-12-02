package es.jfechevarria.data.infrastructure.useCase

import es.jfechevarria.data.infrastructure.UseCase
import es.jfechevarria.domain.post.Post
import es.jfechevarria.domain.post.PostLocalRepository
import es.jfechevarria.domain.post.PostRemoteRepository

class GetAllPostUseCase(
    private val postRemoteRepository: PostRemoteRepository,
    private val postLocalRepository: PostLocalRepository
): UseCase<List<Post>, Unit>() {

    override suspend fun execute(params: Unit): List<Post> {
        var response = postLocalRepository.getPosts()
        if (response.isEmpty()) {
            postLocalRepository.saveAll(postRemoteRepository.get())
            response = postLocalRepository.getPosts()
        }
        return response
    }
}