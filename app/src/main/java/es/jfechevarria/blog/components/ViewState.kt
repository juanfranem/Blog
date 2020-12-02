package es.jfechevarria.blog.components

sealed class ViewState {
    object LOADING : ViewState()
    object IDLE : ViewState()
}