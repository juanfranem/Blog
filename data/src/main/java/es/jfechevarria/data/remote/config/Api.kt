package es.jfechevarria.data.remote.config

import es.jfechevarria.data.infrastructure.comment.remote.CommentRemote
import es.jfechevarria.data.infrastructure.post.remote.PostRemote
import es.jfechevarria.data.infrastructure.user.remote.UserRemote
import retrofit2.http.GET

interface Api {

    @GET(ApiConstants.USERS)
    suspend fun users(): List<UserRemote>

    @GET(ApiConstants.COMMENTS)
    suspend fun comments(): List<CommentRemote>

    @GET(ApiConstants.POSTS)
    suspend fun posts(): List<PostRemote>
}