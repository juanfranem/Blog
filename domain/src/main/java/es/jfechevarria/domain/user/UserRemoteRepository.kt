package es.jfechevarria.domain.user

interface UserRemoteRepository {
    suspend fun get(): List<User>
}