package patterns.structural.composite.real.viewGroup

import patterns.structural.composite.real.View

class LinearLayout : View {
    private val views = mutableListOf<View>()
    fun addView(view: View) = views.add(view)
    override fun hideView() {
        views.forEach { it.hideView() }
    }

    override fun showView() {
        views.forEach { it.showView() }
    }

}