package es.jfechevarria.data.local.repositories

import es.jfechevarria.data.infrastructure.user.local.UserLocal
import es.jfechevarria.data.local.config.UserDao
import es.jfechevarria.domain.user.User
import es.jfechevarria.domain.user.UserLocalRepository

class UserRepositoryImpl(
    private val userDao: UserDao
): UserLocalRepository {
    override suspend fun save(user: User) {
        userDao.saveAll(listOf(UserLocal.fromDomain(user)))
    }

    override suspend fun saveAll(list: List<User>) {
        userDao.saveAll(list.map { UserLocal.fromDomain(it) })
    }

    override suspend fun getById(id: Int): User? {
        return userDao.findUserById(id)?.toDomain()
    }
}