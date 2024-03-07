package dev.aston.intensiv.nikolay.second.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: Int,
    val photoUrl: String,
    val name: String,
    val surname: String,
    val phoneNumber: String
) : Parcelable