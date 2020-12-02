package es.jfechevarria.blog.components

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel(): ViewModel() {

    private val mutableState = MutableLiveData<ViewState>()
    val state: LiveData<ViewState>
        get() = mutableState

    init {
        mutableState.postValue(ViewState.IDLE)
    }

    fun refreshState(state: ViewState){
        mutableState.postValue(state)
    }

}