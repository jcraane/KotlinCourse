package course.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.seconds
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
fun main() = runBlocking {
    val job = launch {
        println("Start coroutine")
        delay(1.seconds)
        println("After 1 second")

        delay(1.seconds)
        println("After 2 seconds")
    }

    job.invokeOnCompletion {
        println("Job completed")
    }

    delay(1.5.seconds)
    println("Cancel job")
    job.cancel()
}
