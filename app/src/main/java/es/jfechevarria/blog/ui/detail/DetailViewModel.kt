package es.jfechevarria.blog.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import es.jfechevarria.blog.components.BaseViewModel
import es.jfechevarria.blog.components.ViewState
import es.jfechevarria.data.infrastructure.useCase.GetCommentByPostUseCase
import es.jfechevarria.data.infrastructure.useCase.GetUserByIdUseCase
import es.jfechevarria.domain.comment.Comment
import es.jfechevarria.domain.post.Post
import es.jfechevarria.domain.user.User
import kotlinx.coroutines.launch
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class DetailViewModel(
    private val getUserByIdUseCase: GetUserByIdUseCase,
    private val getCommentByPostUseCase: GetCommentByPostUseCase
): BaseViewModel() {

     private var mutableUser = MutableLiveData<User>()
      val user: LiveData<User>
         get() = mutableUser

     private var mutableComments = MutableLiveData<List<Comment>>()
      val comments: LiveData<List<Comment>>
         get() = mutableComments

    fun load(post: Post) {
        refreshState(ViewState.LOADING)
        viewModelScope.launch {
            val user = suspendCoroutine<User?> { scope ->
                viewModelScope.launch {
                    getUserByIdUseCase(post.user, onResult = {
                        scope.resume(it)
                    })
                }
            }
            mutableUser.postValue(user)
            val comments = suspendCoroutine<List<Comment>?> { scope ->
                viewModelScope.launch {
                    getCommentByPostUseCase(GetCommentByPostUseCase.Params(post), onResult = {
                        scope.resume(it)
                    })
                }
            }
            mutableComments.postValue(comments)
            refreshState(ViewState.IDLE)
        }
    }

}