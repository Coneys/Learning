package patterns.behavioral.state.stateAsInteraction

import patterns.behavioral.state.NavigationInteraction
import patterns.behavioral.strategy.utils.Distance


sealed class NavigationState(val navigation: Navigation) : NavigationInteraction {

    override fun navigationCancelled() {
        navigation.state = Cancelled(navigation)
    }

    override fun positionOnFinish() {
        if (navigation.state !is Cancelled) {
            navigation.state = Finished(navigation)
        }
    }

    class Idle(navigation: Navigation) : NavigationState(navigation) {
        override fun positionOnRoute(routePercent: Double) {
            navigation.state = Navigating(routePercent, navigation)
        }

        override fun positionOutOfRoute(distance: Distance) {
            navigation.state = OutOfRoute(navigation)
        }

    }

    class OutOfRoute(navigation: Navigation) : NavigationState(navigation) {
        override fun positionOnRoute(routePercent: Double) {
            navigation.state = Navigating(routePercent, navigation)
        }

        override fun positionOutOfRoute(distance: Distance) = Unit

    }

    class Navigating(val routePercent: Double, navigation: Navigation) : NavigationState(navigation) {
        override fun positionOnRoute(routePercent: Double) = Unit

        override fun positionOutOfRoute(distance: Distance) {
            navigation.state = OutOfRoute(navigation)
        }
    }

    class Finished(navigation: Navigation) : NavigationState(navigation) {
        override fun positionOnRoute(routePercent: Double) = Unit
        override fun positionOutOfRoute(distance: Distance) = Unit
    }

    class Cancelled(navigation: Navigation) : NavigationState(navigation) {
        override fun positionOnRoute(routePercent: Double) = Unit
        override fun positionOutOfRoute(distance: Distance) = Unit
        override fun positionOnFinish() = Unit
    }
}