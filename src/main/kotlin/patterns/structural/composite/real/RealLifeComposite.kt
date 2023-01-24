package patterns.structural.composite.real

import patterns.structural.composite.real.viewGroup.LinearLayout
import patterns.structural.composite.real.views.Button
import patterns.structural.composite.real.views.Checkbox
import patterns.structural.composite.real.views.Label

fun main() {

    val someLayout = LinearLayout().apply {
        addView(Checkbox())
    }

    val linearLayout = LinearLayout().apply {
        addView(Button())
        addView(Label())
        addView(someLayout)
    }

    linearLayout.hideView()
    println("---")
    linearLayout.showView()
}