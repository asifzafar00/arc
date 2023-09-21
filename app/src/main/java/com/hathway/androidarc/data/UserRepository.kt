package com.hathway.androidarc.data

interface UserRepository {
    fun findUser(name: String): User?
    fun addUsers(users: List<User>)
}

class UserRepositoryImpl : UserRepository {

    private val _users = arrayListOf<User>()
    override fun findUser(name: String): User? {
        //v _users.firstOrNull { it.name == name }
        return _users.firstOrNull() { it.name == name }
    }

    override fun addUsers(users: List<User>) {
        //  _users.addAll(users)
        _users.addAll(users)
    }


}