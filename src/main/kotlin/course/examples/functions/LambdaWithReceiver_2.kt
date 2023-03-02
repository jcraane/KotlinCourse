package course.examples.functions

fun main() {
    val text1 = buildString {
        append("Hello, ")
        append("World!")
    }

    println(text1)
}

private fun buildString(builderAction: StringBuilder.() -> Unit): String {
    val sb = StringBuilder()
    sb.builderAction()
    return sb.toString()
}
