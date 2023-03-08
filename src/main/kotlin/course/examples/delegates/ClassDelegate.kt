package course.examples.delegates

fun main() {
    class InfoSet<T>(private val delegate: MutableSet<T>) : MutableSet<T> by delegate {
        var additions = 0
            private set

        override fun add(element: T): Boolean {
            additions++
            return delegate.add(element)
        }
    }

    val infoSet = InfoSet<Int>(mutableSetOf())
    (0 until 10).forEach { infoSet.add(kotlin.random.Random.nextInt(0, 3)) }
    println("size: ${infoSet.size}")
    println("additions: ${infoSet.additions}")
}
