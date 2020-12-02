package es.jfechevarria.data.remote.dii

import es.jfechevarria.data.remote.config.provideApi
import es.jfechevarria.data.remote.config.provideOkHttpClient
import es.jfechevarria.data.remote.config.provideRetrofit
import es.jfechevarria.data.remote.repositories.CommentRepositoryImpl
import es.jfechevarria.data.remote.repositories.PostRepositoryImpl
import es.jfechevarria.data.remote.repositories.UserRepositoryImpl
import es.jfechevarria.domain.comment.CommentRemoteRepository
import es.jfechevarria.domain.post.PostRemoteRepository
import es.jfechevarria.domain.user.UserRemoteRepository
import org.koin.dsl.module

val remoteModule = module {
    factory { provideOkHttpClient() }
    single { provideRetrofit(get()) }
    factory { provideApi(get()) }

    factory<CommentRemoteRepository> { CommentRepositoryImpl(get()) }
    factory<PostRemoteRepository> { PostRepositoryImpl(get()) }
    factory<UserRemoteRepository> { UserRepositoryImpl(get()) }
}