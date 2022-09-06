package patterns.creational.abstractFactory.google

import patterns.creational.abstractFactory.contract.LatLng
import patterns.creational.abstractFactory.contract.Marker

class GoogleMapMarker(override val position: LatLng) : Marker {
    override fun toString(): String {
        return "Google marker ${position.latitude} ${position.longitude}"
    }
}