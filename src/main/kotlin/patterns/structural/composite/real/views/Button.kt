package patterns.structural.composite.real.views

import patterns.structural.composite.real.View

class Button : View {
    override fun hideView() {
        println("Hiding button")
    }

    override fun showView() {
        println("Showing button")
    }
}