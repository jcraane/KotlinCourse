package course.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.seconds
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
fun main() = runBlocking { // this: CoroutineScope
    launch { // launch a new coroutine and continue
        delay(1.seconds) // non-blocking delay for 1 second
        println("Hello from coroutine") // print after delay
    }
    println("Hello from main")  // main coroutine continues while a previous one is delayed
}
