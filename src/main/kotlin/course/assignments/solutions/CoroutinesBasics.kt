package course.assignments.solutions

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.seconds
import kotlin.time.ExperimentalTime

private val delay = 1.seconds

@OptIn(ExperimentalTime::class)
fun main() = runBlocking<Unit> {
    val job = launch {
        val customer = getCustomer(1234) // first coroutine to get customer info
        println("Customer name: ${customer.name}")
        val orders = getCustomerOrders(customer.id)
        println("Customer orders: $orders")
    }
}

@OptIn(ExperimentalTime::class)
suspend fun getCustomer(id: Int): Customer {
    println(Thread.currentThread().name)
    delay(delay) // simulate some long running operation
    // in real-world scenario, you might fetch customer info from a remote API or database
    return Customer(id, "John Doe")
}

@OptIn(ExperimentalTime::class)
suspend fun getCustomerOrders(customerId: Int): List<Order> {
    println(Thread.currentThread().name)
    if (customerId == 3) throw RuntimeException("Customer not found")

    return withContext(Dispatchers.IO) {
        println(Thread.currentThread().name)
        delay(delay) // simulate some long running operation
        // in real-world scenario, you might fetch customer orders from a remote API or database
        return@withContext listOf(Order("Order 1"), Order("Order 2"), Order("Order 3"))
    }
}

data class Customer(val id: Int, val name: String)

data class Order(val name: String)
