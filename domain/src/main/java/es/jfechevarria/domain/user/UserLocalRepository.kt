package es.jfechevarria.domain.user

interface UserLocalRepository {
    suspend fun save(user: User)
    suspend fun saveAll(list: List<User>)
    suspend fun getById(id: Int): User?
}