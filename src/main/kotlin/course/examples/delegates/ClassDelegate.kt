package course.examples.delegates

fun main() {
    class InfoSet<T>(private val set: MutableSet<T>) : MutableSet<T> by set {
        var additions = 0
            private set

        override fun add(element: T): Boolean {
            additions++
            return set.add(element)
        }
    }

    val infoSet = InfoSet<Int>(mutableSetOf())
    (0 until 10).forEach { infoSet.add(kotlin.random.Random.nextInt(0, 3)) }
    println("size: ${infoSet.size}")
    println("additions: ${infoSet.additions}")
}
