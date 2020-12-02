package es.jfechevarria.data.infrastructure.user.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import es.jfechevarria.data.infrastructure.post.local.PostLocal
import es.jfechevarria.domain.post.Post
import es.jfechevarria.domain.user.User

@Entity
class UserLocal(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    val website: String
) {
    fun toDomain(): User = User(this.id, this.name, this.email, this.phone, this.website)

    companion object {
        fun fromDomain(user: User): UserLocal = UserLocal(user.id, user.name, user.email, user.phone, user.website)
    }
}