package es.jfechevarria.domain.user

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    val website: String
)