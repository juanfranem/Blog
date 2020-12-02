package es.jfechevarria.data.local.config

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import es.jfechevarria.data.infrastructure.user.local.UserLocal

@Dao
interface UserDao {
    @Insert
    fun saveAll(entities: List<UserLocal>)

    @Query("SELECT * FROM userlocal WHERE id = :id LIMIT 1")
    fun findUserById(id: Int): UserLocal?
}