package course.assignments.solutions

fun main() {
    class ComplexNumber(val real: Double, val imag: Double) {
        operator fun plus(other: ComplexNumber) =
            ComplexNumber(real + other.real, imag + other.imag)

        operator fun minus(other: ComplexNumber) =
            ComplexNumber(real - other.real, imag - other.imag)

        infix fun times(other: ComplexNumber) =
            ComplexNumber(real * other.real - imag * other.imag,
                real * other.imag + imag * other.real)

        override fun toString() = "$real + ${imag}i"
    }

    val c1 = ComplexNumber(1.0, 2.0)
    val c2 = ComplexNumber(3.0, 4.0)
    val sum = c1 + c2
    val difference = c1 - c2
    val product = c1 times c2
    println(sum) // Output: 4.0 + 6.0i
    println(difference) // Output: -2.0 - 2.0i
    println(product) // Output: -5.0 + 10.0i
}
