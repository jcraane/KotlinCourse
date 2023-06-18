package course.examples.controlflow

/**
 * This is a main function that demonstrates the concepts of Kotlin ranges mentioned in the given document.
 */
fun main() {

    // Example 1: Creating a range using the rangeTo() function and checking if a value is in the range
    val range = 1.rangeTo(4)
    val i = 2
    if (i in range) {
        println(i) // Output: 2
    }

    // Example 2: Iterating over a range using a for loop
    for (num in 1..4) {
        print(num) // Output: 1234
    }

    println() // Adding a new line

    // Example 3: Iterating over a range in reverse order
    for (num in 4 downTo 1) {
        print(num) // Output: 4321
    }

    println() // Adding a new line

    // Example 4: Iterating over a range with a step
    for (num in 1..8 step 2) {
        print(num) // Output: 1357
    }

    println() // Adding a new line

    for (num in 8 downTo 1 step 2) {
        print(num) // Output: 8642
    }

    println() // Adding a new line

    // Example 5: Iterating over a range that excludes its end element
    for (num in 1 until 10) {
        print(num) // Output: 123456789
    }

    println() // Adding a new line

    // Example 6: Creating a custom range for a class and checking if a value is in the range
    val versionRange = Version(1, 11)..Version(1, 30)
    val version1 = Version(0, 9)
    val version2 = Version(1, 20)
    println(version1 in versionRange) // Output: false
    println(version2 in versionRange) // Output: true

    // Example 7: Iterating over a range implicitly creates a progression
    for (num in 1..10) {
        print(num) // Output: 12345678910
    }

    println() // Adding a new line

    // Example 8: Creating a custom progression with a step
    for (num in 1..8 step 2) {
        print(num) // Output: 1357
    }

    println() // Adding a new line

    // Example 9: Last element of a progression may not be the same as the specified end value
    for (num in 1..9 step 3) {
        print(num) // Output: 147
    }

    println() // Adding a new line

    // Example 10: Iterating over a range in reverse order using downTo
    for (num in 4 downTo 1) {
        print(num) // Output: 4321
    }

    println() // Adding a new line

    // Example 11: Iterating over a progression in reverse order using the reversed() function
    for (num in (1..4).reversed()) {
        print(num) // Output: 4321
    }

    println() // Adding a new line

    // Example 12: Using a progression with collection functions
    val evenNumbers = (1..10).filter { it % 2 == 0 }
    println(evenNumbers) // Output: [2, 4, 6, 8, 10]
}

/**
 * A sample class representing a version number.
 */
class Version(val major: Int, val minor: Int) {
    // Custom implementation of the rangeTo() function for creating ranges of Version objects
    operator fun rangeTo(other: Version) = VersionRange(this, other)

    // Custom implementation of the contains() function to check if a Version is in the range
    operator fun contains(version: Version): Boolean {
        return this.major <= version.major && version.major <= this.minor
    }

    operator fun compareTo(version: Version): Int {
        return when {
            this.major > version.major -> 1
            this.major < version.major -> -1
            this.minor > version.minor -> 1
            this.minor < version.minor -> -1
            else -> 0
        }
    }
}

/**
 * A helper class representing a range of Version objects.
 */
class VersionRange(val start: Version, val endInclusive: Version) {
    // Custom implementation of the contains() function to check if a Version is in the range
    operator fun contains(version: Version): Boolean {
        return start <= version && version <= endInclusive
    }
}
