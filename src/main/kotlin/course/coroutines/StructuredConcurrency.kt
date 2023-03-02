package course.coroutines

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.seconds
import kotlin.time.ExperimentalTime

fun main() = runBlocking {
    launch {
        val user = retrieveUser("1")
        println(user)

        val balance = checkBalance(user.accountId)
        println(balance)
    }

    println("DONE")
}

@OptIn(ExperimentalTime::class)
private suspend fun retrieveUser(userId: String): User = withContext(Dispatchers.IO) {
    delay(1.seconds)
    User(userId, "1")
}

@OptIn(ExperimentalTime::class)
private suspend fun checkBalance(accountId: String) = withContext(Dispatchers.IO) {
    delay(1.seconds)
    100
}

private data class User(val id: String, val accountId: String)
