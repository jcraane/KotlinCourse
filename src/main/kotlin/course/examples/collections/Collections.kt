package course.examples.collections

data class Student(val name: String, val grade: Int)

fun main() {
    // Creating a list of students
    val students = listOf(
        Student("John", 85),
        Student("Emily", 92),
        Student("Michael", 78),
        Student("Sophia", 65),
        Student("Jacob", 89)
    )

    // Performing operators on the list
    val passedStudents = students.filter { it.grade >= 70 } // Filter to get only passing grades
    val totalGrades = students.map { it.grade } // Get a list of all grades

    // Use map operator like reduce
    val averageGrade = totalGrades.reduce { acc, grade ->
        acc + grade
    } / totalGrades.size.toFloat()

    // Printing the results
    println("Passed Students:")
    for (student in passedStudents) {
        println("${student.name}: ${student.grade}")
    }

    println("Average Grade: $averageGrade")
}
