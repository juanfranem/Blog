package es.jfechevarria.domain.comment

data class Comment(
    val id: Int,
    val post: Int,
    val name: String,
    val email: String,
    val body: String
)