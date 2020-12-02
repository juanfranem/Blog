package es.jfechevarria.blog.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import es.jfechevarria.blog.components.BaseViewModel
import es.jfechevarria.blog.components.ViewState
import es.jfechevarria.data.infrastructure.useCase.GetAllPostUseCase
import es.jfechevarria.domain.post.Post
import kotlinx.coroutines.launch

class MainViewModel(
    private val getAllPostUseCase: GetAllPostUseCase
): BaseViewModel() {

     private var _data = MutableLiveData<List<Post>>()
      val data: LiveData<List<Post>>
         get() = _data

    fun load() {
        refreshState(ViewState.LOADING)
        viewModelScope.launch {
            getAllPostUseCase(Unit, onResult = {
                _data.postValue(it)
                refreshState(ViewState.IDLE)
            })
        }
    }
}