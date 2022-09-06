package patterns.creational.abstractFactory.mapbox

import patterns.creational.abstractFactory.MapElementsFactory
import patterns.creational.abstractFactory.contract.LatLng
import patterns.creational.abstractFactory.contract.Marker
import patterns.creational.abstractFactory.contract.Polyline

class MapboxFactory : MapElementsFactory {
    override fun createMarker(latLng:LatLng): Marker {
        return MapboxMarker(latLng)
    }

    override fun createPolyline(points: List<LatLng>): Polyline {
        return MapboxPolyline(points)
    }
}