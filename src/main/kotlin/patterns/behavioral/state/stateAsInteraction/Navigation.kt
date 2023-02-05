package patterns.behavioral.state.stateAsInteraction

class Navigation {
    internal var state: NavigationState = NavigationState.Idle(this)
}