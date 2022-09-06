package patterns.structural.abstractFactory

data class LatLng(val latitude: Double, val longitude: Double)

interface Marker {
    val position: LatLng
}

interface Polyline {
    val points: List<LatLng>
}

interface MapElementsFactory {
    fun createMarker(latitude: Double, longitude: Double): Marker
    fun createPolyline(points: List<LatLng>): Polyline
}

class MapboxMarker(override val position: LatLng) : Marker {
    override fun toString(): String {
        return "Mapbox marker ${position.latitude} ${position.longitude}"
    }
}

class GoogleMapMarker(override val position: LatLng) : Marker {
    override fun toString(): String {
        return "Google marker ${position.latitude} ${position.longitude}"
    }
}