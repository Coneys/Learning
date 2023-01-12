package patterns.structural.bridge.inRealLife

interface Weapon {
    fun attack(target: String)
}

interface Legs {
    fun move(x: Int, y: Int)
}

data class StarWarsTrooper(val weapon: Weapon, val legs: Legs) : Trooper {
    override fun attack(target: String) {
        weapon.attack(target)
    }

    override fun move(x: Int, y: Int) {
        legs.move(x, y)
    }
}

class Rifle : Weapon {
    override fun attack(target: String) {

    }
}

class ElectricBaton : Weapon {
    override fun attack(target: String) {

    }
}

class FlameThrower : Weapon {
    override fun attack(target: String) {

    }

}


class NormalLegs : Legs {
    override fun move(x: Int, y: Int) {
    }

}

class SlowerLegs : Legs {
    override fun move(x: Int, y: Int) {
    }

}

fun main() {

    val defaultStormTrooper = StarWarsTrooper(Rifle(), NormalLegs())
    val riotControlStormTrooper = StarWarsTrooper(ElectricBaton(), NormalLegs())
    val fireStormTrooper = StarWarsTrooper(FlameThrower(), SlowerLegs())

}