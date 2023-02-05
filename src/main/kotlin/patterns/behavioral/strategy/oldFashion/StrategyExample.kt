package patterns.behavioral.strategy.oldFashion


fun main() {
    val navigation = Navigation()
    navigation.calculator = BikeDurationLeftCalculator()

    val distance = 100 //kilometers

    navigation.timeLeft(distance).also { println(it) }
    navigation.calculator = CarDurationLeftCalculator()
    navigation.timeLeft(distance).also { println(it) }

}