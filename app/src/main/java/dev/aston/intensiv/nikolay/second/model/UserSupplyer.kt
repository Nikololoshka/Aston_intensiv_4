package dev.aston.intensiv.nikolay.second.model

import kotlin.random.Random

object UserSupplyer {

    fun loadUsers(): List<User> = MutableList(4) { index ->
        User(
            id = index,
            photoUrl = "https://loremflickr.com/640/360?lock=$index",
            name = "User #$index",
            surname = "Surname #$index",
            phoneNumber = Random.nextLong(7_000_000_00_00, 7_999_999_99_99).toString()
        )
    }
}