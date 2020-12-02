package es.jfechevarria.data.local.dii

import androidx.room.Room
import es.jfechevarria.data.local.config.BlogDatabase
import es.jfechevarria.data.local.repositories.CommentRepositoryImpl
import es.jfechevarria.data.local.repositories.PostRepositoryImpl
import es.jfechevarria.data.local.repositories.UserRepositoryImpl
import es.jfechevarria.domain.comment.CommentLocalRepository
import es.jfechevarria.domain.post.PostLocalRepository
import es.jfechevarria.domain.user.UserLocalRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val localModule = module {
    single { Room.databaseBuilder(androidApplication(), BlogDatabase::class.java, "blog_db").build() }

    single { get<BlogDatabase>().postDao() }
    single { get<BlogDatabase>().userDao() }
    single { get<BlogDatabase>().commentDao() }

    factory<CommentLocalRepository> { CommentRepositoryImpl(get()) }
    factory<PostLocalRepository> { PostRepositoryImpl(get()) }
    factory<UserLocalRepository> { UserRepositoryImpl(get()) }
}