package com.hathway.androidarc

class UserRepository {
    val users = listOf<User>(
        User(1, "John", "john@yahoo.com", "1qaz2wsx3edc"),
        User(2, "Polu", "polu@yahoo.com", "qwerty"),
        User(3, "Hari", "hari@yahoo.com", "zxcasdqwe"),
        User(4, "Emily", "emily@yahoo.com", "mnblkjpoi")
    )

    fun loginUser(email: String, password: String): LOGIN_STATUS {
        val users = users.filter { user -> user.email == email }
        return if (users.size == 1) {
            if (users[0].password == password) {
                LOGIN_STATUS.SUCCESS
            } else {
                LOGIN_STATUS.INVALID_PASSWORD
            }
        } else {
            LOGIN_STATUS.INVALID_USER

        }
    }
}