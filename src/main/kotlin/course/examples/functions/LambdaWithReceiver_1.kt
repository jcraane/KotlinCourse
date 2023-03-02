package course.examples.functions

fun main() {
    val text1 = buildString {
        it.append("Hello, ")
        it.append("World!")
    }

    println(text1)
}

private fun buildString(builderAction: (StringBuilder) -> Unit): String {
    val sb = StringBuilder()
    builderAction(sb)
    return sb.toString()
}
