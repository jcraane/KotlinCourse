import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

@OptIn(InternalCoroutinesApi::class)
suspend fun main() {
    withContext(Dispatchers.IO) {
        val c1 = launch(CoroutineName("Coroutine 1")) {
            val sharedFlow = sharedFlow(this@withContext)
            sharedFlow.collect {
                println("1: $it")
            }

            sharedFlow.collect {
                println("1: $it")
            }
        }

        val c2 = launch(CoroutineName("Coroutine 2")) {
            val sharedFlow = sharedFlow(this@withContext)
            sharedFlow.collect {
                println("2: $it")
            }

            sharedFlow.collect {
                println("2: $it")
            }
        }
    }
}

fun sharedFlow(scope: CoroutineScope) = flow {
    emit(1)
    emit(2)
    emit(3)
}
    .onStart { println("Started") }
    .onCompletion { println("Completed") }
    .shareIn(scope + CoroutineName("shared"), SharingStarted.Eagerly)
