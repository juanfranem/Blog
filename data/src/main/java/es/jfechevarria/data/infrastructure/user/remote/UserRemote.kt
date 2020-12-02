package es.jfechevarria.data.infrastructure.user.remote

import es.jfechevarria.domain.user.User

class UserRemote(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val phone: String,
    val website: String
) {
    fun toDomain(): User = User(this.id, this.name, this.email, this.phone, this.website)
}