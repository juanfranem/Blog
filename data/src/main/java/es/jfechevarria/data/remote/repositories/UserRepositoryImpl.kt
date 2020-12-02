package es.jfechevarria.data.remote.repositories

import es.jfechevarria.data.remote.config.Api
import es.jfechevarria.domain.user.User
import es.jfechevarria.domain.user.UserRemoteRepository

class UserRepositoryImpl(
    private val api: Api
): UserRemoteRepository {
    override suspend fun get(): List<User> {
        return api.users().map { it.toDomain() }
    }
}