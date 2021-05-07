package behavioral.chain_of_responsibility.middleware

class ThrottlingMiddleware(private val requestPerMinute: Int) : Middleware() {
    private var request = 0
    private var currentTime: Long

    init {
        currentTime = System.currentTimeMillis()
    }

    override fun check(email: String, password: String): Boolean {
        if (System.currentTimeMillis() > currentTime + 60000) {
            request = 0
            currentTime = System.currentTimeMillis()
        }
        request++
        if (request > requestPerMinute) {
            println("Request limit exceeded!")
            Thread.currentThread().stop()
        }
        return checkNext(email, password)
    }
}