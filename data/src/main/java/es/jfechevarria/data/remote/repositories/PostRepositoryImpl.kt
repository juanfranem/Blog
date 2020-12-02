package es.jfechevarria.data.remote.repositories

import es.jfechevarria.data.remote.config.Api
import es.jfechevarria.domain.post.Post
import es.jfechevarria.domain.post.PostRemoteRepository

class PostRepositoryImpl(
    private val api: Api
): PostRemoteRepository {
    override suspend fun get(): List<Post> {
        return api.posts().map { it.toDomain() }
    }
}