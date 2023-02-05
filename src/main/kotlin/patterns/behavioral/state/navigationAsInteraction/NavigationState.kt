package patterns.behavioral.state.navigationAsInteraction

sealed interface NavigationState {
    object Idle : NavigationState
    object OutOfRoute : NavigationState
    class Navigating(val routePercent: Double) : NavigationState
    object Finished : NavigationState
    object Cancelled : NavigationState
}