package patterns.creational.abstractFactory.mapbox

import patterns.creational.abstractFactory.contract.LatLng
import patterns.creational.abstractFactory.contract.Marker

class MapboxMarker(override val position: LatLng) : Marker {
    override fun toString(): String {
        return "Mapbox marker ${position.latitude} ${position.longitude}"
    }
}