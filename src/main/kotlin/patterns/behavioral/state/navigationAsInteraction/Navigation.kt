package patterns.behavioral.state.navigationAsInteraction

import patterns.behavioral.state.NavigationInteraction
import patterns.behavioral.strategy.utils.Distance


class Navigation() : NavigationInteraction {
    private var state: NavigationState = NavigationState.Idle

    override fun positionOnRoute(routePercent: Double) {
        state = if (state is NavigationState.OutOfRoute)
            NavigationState.Navigating(routePercent)
        else state
    }

    override fun positionOutOfRoute(distance: Distance) {
        state = if (state is NavigationState.Navigating)
            NavigationState.OutOfRoute
        else state
    }

    override fun positionOnFinish() {
        state = if (state !is NavigationState.Cancelled)
            NavigationState.Finished
        else state
    }

    override fun navigationCancelled() {
        state = NavigationState.Cancelled
    }

}