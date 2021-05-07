package behavioral.chain_of_responsibility.server

import behavioral.chain_of_responsibility.middleware.Middleware

import java.util.HashMap


class Server {
    private val users: MutableMap<String, String> = HashMap()
    private var middleware: Middleware? = null

    fun setMiddleware(middleware: Middleware) {
        this.middleware = middleware
    }

    fun logIn(email: String, password: String): Boolean {
        if (middleware?.check(email, password) == true) {
            println("Authorization have been successful!")

            // some useful code for authorized users
            return true
        }
        return false
    }

    fun register(email: String, password: String) {
        users[email] = password
    }

    fun hasEmail(email: String): Boolean {
        return users.containsKey(email)
    }

    fun isValidPassword(email: String, password: String): Boolean {
        return users[email] == password
    }
}