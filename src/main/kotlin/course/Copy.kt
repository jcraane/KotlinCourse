package course

import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import java.lang.RuntimeException

@OptIn(InternalCoroutinesApi::class)
fun main() = runBlocking<Unit> {

    flow<String> {
        emit("Hello")
        emit("World")
    }
        .filter {
            if (it == "World") {
                throw RuntimeException("World is not allowed")
            }

            true
        }
        .catch { e ->
            println("Caught $e")
        }
        .collect {
            println(it)
        }

}

