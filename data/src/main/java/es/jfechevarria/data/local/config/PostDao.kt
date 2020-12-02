package es.jfechevarria.data.local.config

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import es.jfechevarria.data.infrastructure.post.local.PostLocal

@Dao
interface PostDao {
    @Insert
    fun saveAll(entities: List<PostLocal>)

    @Query("SELECT * FROM postlocal")
    fun getPosts(): List<PostLocal>
}