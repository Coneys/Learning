package patterns.structural.adapter

import patterns.creational.abstractFactory.contract.LatLng

interface NavigationAttraction {
    val iconUrl: String
    val name: String
    val position: LatLng
}

class TraseoPoi(val id: Int, val photoUrl: String, val title: String, val lat: Double, val lng: Double)
class OpenStreetMapObject(val id: Int, val categoryIconName: String, val position: String)
class TreespotItem(val id: Int, val name: String, val thumbId: Int, val position: LatLng)


//Podejście 'Javovwe'

class TraseoPoiNavigationAttraction(traseoPoi: TraseoPoi) : NavigationAttraction {
    override val iconUrl: String = traseoPoi.photoUrl
    override val name: String = traseoPoi.title
    override val position: LatLng = LatLng(traseoPoi.lat, traseoPoi.lng)
}

// Podejście nowoczesne

fun TraseoPoi.asNavigationAttraction(): NavigationAttraction {
    return object : NavigationAttraction {
        override val iconUrl: String = photoUrl
        override val name: String = title
        override val position: LatLng = LatLng(lat, lng)
    }
}

fun OpenStreetMapObject.asNavigationAttraction(): NavigationAttraction {
    val (lat, lng) = position.split(",").map { it.toDouble() }
    return object : NavigationAttraction {
        override val iconUrl: String = "https://www.openstreemap/category/$categoryIconName/icon.png"
        override val name: String = ""
        override val position: LatLng = LatLng(lat, lng)
    }
}


fun TreespotItem.asNavigationAttraction(): NavigationAttraction {
    val treespotName = name
    val treespotPosition = position
    return object : NavigationAttraction {
        override val iconUrl: String = "www.treespot.pl/multimedia$thumbId.png"
        override val name: String = treespotName
        override val position: LatLng = treespotPosition
    }
}