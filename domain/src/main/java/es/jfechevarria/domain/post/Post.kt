package es.jfechevarria.domain.post

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post(
    val id: Int,
    val title: String,
    val user: Int,
    val body: String
): Parcelable