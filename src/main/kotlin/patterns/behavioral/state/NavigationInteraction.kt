package patterns.behavioral.state

import patterns.behavioral.strategy.utils.Distance

interface NavigationInteraction {
    fun positionOnRoute(routePercent: Double)
    fun positionOutOfRoute(distance: Distance)
    fun positionOnFinish()
    fun navigationCancelled()
}
