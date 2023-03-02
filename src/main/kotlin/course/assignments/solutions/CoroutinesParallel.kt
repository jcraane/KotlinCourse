package course.assignments.solutions

import kotlinx.coroutines.*
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@OptIn(ExperimentalTime::class)
fun main() = runBlocking<Unit> {
    val customerIds = (4..6).toList()
    val job = launch {
        val time = measureTime {

            val deferred = customerIds.map {
                async {
                    getCustomer(it) }
            }

            val customers = deferred.awaitAll()
            val orders = customers.map {
                async { getCustomerOrders(it.id) }
            }.awaitAll().flatten()

            println(orders)

            /*val allOrders = customerIds
                .map { getCustomer(it) }
                .flatMap {
                    getCustomerOrders(it.id)
                }
            println(allOrders)*/
        }

        println("Time: $time")
    }
}
