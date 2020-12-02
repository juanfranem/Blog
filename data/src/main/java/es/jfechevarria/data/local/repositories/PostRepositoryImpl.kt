package es.jfechevarria.data.local.repositories

import es.jfechevarria.data.infrastructure.post.local.PostLocal
import es.jfechevarria.data.local.config.PostDao
import es.jfechevarria.data.remote.config.Api
import es.jfechevarria.domain.post.Post
import es.jfechevarria.domain.post.PostLocalRepository

class PostRepositoryImpl(private val postDao: PostDao): PostLocalRepository {

    override suspend fun savePost(post: Post) {
        postDao.saveAll(listOf(PostLocal.fromDomain(post)))
    }

    override suspend fun saveAll(list: List<Post>) {
        postDao.saveAll(list.map { PostLocal.fromDomain(it) })
    }

    override suspend fun getPosts(): List<Post> {
        return postDao.getPosts().map { it.toDomain() }
    }

}