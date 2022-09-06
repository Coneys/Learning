package patterns.creational.abstractFactory.google

import patterns.creational.abstractFactory.MapElementsFactory
import patterns.creational.abstractFactory.contract.LatLng
import patterns.creational.abstractFactory.contract.Marker
import patterns.creational.abstractFactory.contract.Polyline

class GoogleMapFactory : MapElementsFactory {
    override fun createMarker(latLng: LatLng): Marker {
        return GoogleMapMarker(latLng)
    }

    override fun createPolyline(points: List<LatLng>): Polyline {
        return GoogleMapPolyline(points)
    }
}