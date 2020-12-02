package es.jfechevarria.data.local.config

import androidx.room.Database
import androidx.room.RoomDatabase
import es.jfechevarria.data.infrastructure.comment.local.CommentLocal
import es.jfechevarria.data.infrastructure.post.local.PostLocal
import es.jfechevarria.data.infrastructure.user.local.UserLocal

@Database(entities = [PostLocal::class, CommentLocal::class, UserLocal::class], version = 1)
abstract class BlogDatabase: RoomDatabase() {
    abstract fun commentDao(): CommentDao
    abstract fun postDao(): PostDao
    abstract fun userDao(): UserDao
}