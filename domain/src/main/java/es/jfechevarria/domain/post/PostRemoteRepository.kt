package es.jfechevarria.domain.post

interface PostRemoteRepository {
    suspend fun get(): List<Post>
}