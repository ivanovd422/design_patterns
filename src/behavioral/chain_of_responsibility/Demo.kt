package behavioral.chain_of_responsibility

import java.io.IOException

import behavioral.chain_of_responsibility.middleware.RoleCheckMiddleware

import behavioral.chain_of_responsibility.middleware.ThrottlingMiddleware

import behavioral.chain_of_responsibility.middleware.Middleware
import behavioral.chain_of_responsibility.middleware.UserExistsMiddleware
import behavioral.chain_of_responsibility.server.Server
import java.io.InputStreamReader
import java.io.BufferedReader


object Demo {
    private val reader = BufferedReader(InputStreamReader(System.`in`))
    private var server: Server? = null

    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        init()
        var success: Boolean
        do {
            print("Enter email: ")
            val email = reader.readLine()
            print("Input password: ")
            val password = reader.readLine()
            success = server?.logIn(email, password) ?: false
        } while (!success)
    }

    private fun init() {

        server = Server().apply {
            register("admin@example.com", "admin_pass")
            register("user@example.com", "user_pass")
        }

        val middleware: Middleware = ThrottlingMiddleware(2)

        middleware
            .linkWith(UserExistsMiddleware(server!!))
            .linkWith(RoleCheckMiddleware())

        server!!.setMiddleware(middleware)
    }


}