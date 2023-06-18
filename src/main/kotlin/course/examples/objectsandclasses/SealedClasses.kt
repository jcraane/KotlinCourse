package course.examples.objectsandclasses

sealed class Shape {
    class Circle(val radius: Double) : Shape()
    class Rectangle(val width: Double, val height: Double) : Shape()
    class Triangle(val base: Double, val height: Double) : Shape()
}

fun main() {
    val shape: Shape = Shape.Circle(10.0)

    when (shape) {
        is Shape.Circle -> println("Circle with radius ${shape.radius}")
        is Shape.Rectangle -> println("Rectangle with width ${shape.width} and height ${shape.height}")
        is Shape.Triangle -> println("Triangle with base ${shape.base} and height ${shape.height}")
    }
}
