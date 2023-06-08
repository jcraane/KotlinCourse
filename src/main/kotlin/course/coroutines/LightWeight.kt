package course.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.atomic.AtomicInteger

fun main() = runBlocking {
    val count = AtomicInteger(0)
    repeat(50_000) { // launch a lot of coroutines
        launch {
            val actual = count.incrementAndGet()
            if (actual == 25_000) {
                println("Reached 25,000")
            }
            delay(5000L)
            print(".")
        }
    }
}
