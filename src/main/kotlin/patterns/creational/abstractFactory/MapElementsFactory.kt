package patterns.creational.abstractFactory

import patterns.creational.abstractFactory.contract.LatLng
import patterns.creational.abstractFactory.contract.Marker
import patterns.creational.abstractFactory.contract.Polyline
import patterns.creational.abstractFactory.google.GoogleMapFactory
import patterns.creational.abstractFactory.mapbox.MapboxFactory

interface MapElementsFactory {
    fun createMarker(latLng: LatLng): Marker
    fun createPolyline(points: List<LatLng>): Polyline

    companion object {
        fun google(): MapElementsFactory = GoogleMapFactory()
        fun mapbox(): MapElementsFactory = MapboxFactory()
    }
}


fun main() {
    val point = LatLng(50.0, 20.0)
    val secondPoint = LatLng(50.0, 20.0)


    val factory = MapElementsFactory.mapbox()

    val marker = factory.createMarker(point)
    val polyline = factory.createPolyline(listOf(point, secondPoint))

    println(marker)
    println(polyline)

}
