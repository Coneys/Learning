package patterns.creational.abstractFactory.mapbox

import patterns.creational.abstractFactory.contract.LatLng
import patterns.creational.abstractFactory.contract.Polyline

class MapboxPolyline(override val points: List<LatLng>) : Polyline {
    override fun toString(): String {
        return "Mapbox polyline ${points.joinToString()}"
    }
}