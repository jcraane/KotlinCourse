package course.assignments.solutions

import kotlinx.coroutines.*
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@OptIn(ExperimentalTime::class)
fun main() = runBlocking<Unit> {
    val customerIds = (1..3).toList()
    val job = launch {
        val time  = measureTime {
            val allOrders = customerIds
                .map { getCustomer(it) }
                .flatMap {
                    try {
                        getCustomerOrders(it.id)
                    } catch (e: Exception) {
                        emptyList()
                    }
                }
            println(allOrders)
        }

        println("Time: $time")
    }
}
