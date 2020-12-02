package es.jfechevarria.domain.post

interface PostLocalRepository {
    suspend fun savePost(post: Post)
    suspend fun saveAll(list: List<Post>)
    suspend fun getPosts(): List<Post>
}