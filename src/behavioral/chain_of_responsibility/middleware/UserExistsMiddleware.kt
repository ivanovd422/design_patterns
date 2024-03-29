package behavioral.chain_of_responsibility.middleware

import behavioral.chain_of_responsibility.server.Server

class UserExistsMiddleware(private val server: Server) : Middleware() {

    override fun check(email: String, password: String): Boolean {
        if (!server.hasEmail(email)) {
            println("This email is not registered!")
            return false
        }
        if (!server.isValidPassword(email, password)) {
            println("Wrong password!")
            return false
        }
        return checkNext(email, password)
    }
}