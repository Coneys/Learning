package patterns.creational.abstractFactory.google

import patterns.creational.abstractFactory.contract.LatLng
import patterns.creational.abstractFactory.contract.Polyline

class GoogleMapPolyline(override val points: List<LatLng>) : Polyline {
    override fun toString(): String {
        return "Google polyline ${points.joinToString()}"
    }
}