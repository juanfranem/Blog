package es.jfechevarria.data.local.config

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import es.jfechevarria.data.infrastructure.comment.local.CommentLocal

@Dao
interface CommentDao {
    @Insert
    fun saveAll(entities: List<CommentLocal>)

    @Query("SELECT * FROM commentlocal WHERE postId = :post")
    fun findCommentsByPost(post: Int): List<CommentLocal>
}