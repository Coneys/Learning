package patterns.behavioral.strategy.oldFashion

import patterns.behavioral.strategy.utils.Distance
import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours

class CarDurationLeftCalculator : DurationLeftCalculator {
    override fun calculate(distance: Distance): Duration {
        val speed = 60.0
        println("Calculating for Car")
        return (distance.toDouble() / speed).hours
    }
}