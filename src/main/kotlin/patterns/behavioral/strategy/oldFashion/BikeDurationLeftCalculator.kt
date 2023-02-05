package patterns.behavioral.strategy.oldFashion

import patterns.behavioral.strategy.utils.Distance
import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours

class BikeDurationLeftCalculator : DurationLeftCalculator {
    override fun calculate(distance: Distance): Duration {
        val speed = 13.0
        println("Calculating for Bike")
        return (distance.toDouble() / speed).hours
    }
}