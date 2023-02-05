package patterns.behavioral.strategy.oldFashion

import patterns.behavioral.strategy.utils.Distance
import kotlin.time.Duration

interface DurationLeftCalculator {
    fun calculate(distance: Distance): Duration
}