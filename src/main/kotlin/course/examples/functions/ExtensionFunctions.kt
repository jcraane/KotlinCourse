package course.examples.functions

fun main() {
    val list = mutableListOf(1, 2, 3)
    println(list)
    list.swap(0, 2) // 'this' inside 'swap()' will hold the value of 'list'
    println(list)
}

fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}
