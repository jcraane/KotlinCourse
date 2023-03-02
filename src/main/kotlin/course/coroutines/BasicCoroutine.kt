package course.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.seconds
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
fun main() = runBlocking {
    val job = launch {
        delay(1.seconds) // Does not block
        println("Hello from coroutine")
    }
    println("Hello from main")
    job.join()
}
