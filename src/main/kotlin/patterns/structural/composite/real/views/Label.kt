package patterns.structural.composite.real.views

import patterns.structural.composite.real.View

class Label : View {
    override fun hideView() {
        println("Hiding label")
    }

    override fun showView() {
        println("Showing label")
    }
}