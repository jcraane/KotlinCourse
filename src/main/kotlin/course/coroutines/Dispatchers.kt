package course.coroutines

import kotlinx.coroutines.*

@OptIn(ObsoleteCoroutinesApi::class)
fun main() = runBlocking {
    launch { // context of the parent, main runBlocking coroutine
        println("main runBlocking      : I'm working in thread ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Unconfined) { // not confined -- will work with main thread
        println("Unconfined            : I'm working in thread ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Default) { // will get dispatched to DefaultDispatcher
        println("Default               : I'm working in thread ${Thread.currentThread().name}")
    }
    launch(Dispatchers.IO) { // will get dispatched to DefaultDispatcher
        println("IO                    : I'm working in thread ${Thread.currentThread().name}")
    }
    launch(newSingleThreadContext("MyOwnThread")) { // will get its own new thread
        println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
    }

    // Main safe
    launch {
        println("Execute on ${Thread.currentThread().name}")
        val result = expensiveComputation()
        println("Process result on ${Thread.currentThread().name}")
        println("Result: $result")
    }


    println("All Done")
}

// This function runs on a separate thread
private suspend fun expensiveComputation(): Int = withContext(Dispatchers.Default) {
    println("Expensive operation executing on ${Thread.currentThread().name}")
    delay(1000)
    42
}
