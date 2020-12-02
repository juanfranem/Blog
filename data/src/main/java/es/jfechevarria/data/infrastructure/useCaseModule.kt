package es.jfechevarria.data.infrastructure

import es.jfechevarria.data.infrastructure.useCase.GetAllPostUseCase
import es.jfechevarria.data.infrastructure.useCase.GetCommentByPostUseCase
import es.jfechevarria.data.infrastructure.useCase.GetUserByIdUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetAllPostUseCase(get(), get()) }
    factory { GetCommentByPostUseCase(get(), get()) }
    factory { GetUserByIdUseCase(get(), get()) }
}