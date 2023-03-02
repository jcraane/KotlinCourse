package course.examples

import java.awt.Color

fun main() {
    val (r, g, b) = Color(0, 255, 0)
    println("r: $r, g: $g, b: $b")

}

operator fun Color.component1() = red
operator fun Color.component2() = green
operator fun Color.component3() = blue
