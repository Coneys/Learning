package patterns.structural.staticFactoryMethod


sealed class Shape {
    data class Circle internal constructor(val radius: Int) : Shape()
    data class Rectangle internal constructor(val a: Int, val b: Int) : Shape()

    companion object {
        fun from(text: String): Shape {
            val shapeCode = text.first().lowercase()
            return when (shapeCode) {
                "c" -> Circle(text.drop(1).toInt())
                "r" -> {
                    val (a, b) = text.drop(1).split(",")
                    Rectangle(a.toInt(), b.toInt())
                }
                else -> error("Unknown shape $shapeCode")
            }
        }

        fun fromOrNull(text: String) = kotlin.runCatching { from(text) }.getOrNull()
    }
}

fun main() {
    val circle = Shape.from("c5")
    val rectangle = Shape.from("r4,2")
    val incorrect = Shape.fromOrNull("k4")

    println("Circle $circle")
    println("Rectangle $rectangle")
    println("Incorrect $incorrect")
}