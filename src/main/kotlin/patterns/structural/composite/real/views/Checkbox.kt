package patterns.structural.composite.real.views

import patterns.structural.composite.real.View

class Checkbox : View {
    override fun hideView() {
        println("Hiding checkbox")
    }

    override fun showView() {
        println("Showing checkbox")
    }
}