package es.jfechevarria.data.infrastructure.useCase

import es.jfechevarria.data.infrastructure.UseCase
import es.jfechevarria.domain.user.User
import es.jfechevarria.domain.user.UserLocalRepository
import es.jfechevarria.domain.user.UserRemoteRepository

class GetUserByIdUseCase(
    private val userRemoteRepository: UserRemoteRepository,
    private val userLocalRepository: UserLocalRepository
): UseCase<User?, Int>() {
    override suspend fun execute(params: Int): User? {
        var response = userLocalRepository.getById(params)
        if (response == null) {
            userLocalRepository.saveAll(userRemoteRepository.get())
            response = userLocalRepository.getById(params)
        }
        return response
    }

}