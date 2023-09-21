package com.hathway.androidarc

import com.hathway.androidarc.data.UserRepository


/**
 * Simple presenter - use the HelloRepository to "say" hello
 */
class UserPresenter(private val repository: UserRepository) {

    fun sayHello(name: String): String {
        val foundUser = repository.findUser(name)
        return foundUser?.let { "Hello '$it' from $this" } ?: "User '$name' not found!"
    }
}