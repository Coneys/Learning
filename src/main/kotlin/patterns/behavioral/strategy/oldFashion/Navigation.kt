package patterns.behavioral.strategy.oldFashion

import patterns.behavioral.strategy.utils.Distance

class Navigation(initialCalculator: DurationLeftCalculator = BikeDurationLeftCalculator()) {
    var calculator: DurationLeftCalculator = initialCalculator

    fun timeLeft(distance: Distance) = calculator.calculate(distance)
}