package patterns.structural.bridge.inRealLife


interface Trooper {
    fun attack(target: String)
    fun move(x: Int, y: Int)
}

open class StormTrooper : Trooper {
    override fun attack(target: String) {
        // zwykle chybia
    }

    override fun move(x: Int, y: Int) {
        //biega wolno
    }

}

class ShockTrooper : Trooper {
    override fun attack(target: String) {
        // czasem trafia
    }

    override fun move(x: Int, y: Int) {
        //biega bardzo wolno
    }

}


class RiotControlTrooper : StormTrooper() {
    override fun attack(target: String) {
        // ma elektryczny miecz
    }
}

class FlameTrooper : StormTrooper() {
    override fun attack(target: String) {
        // atakuje ogniem, zawsze trafia
    }

    override fun move(x: Int, y: Int) {
        // porusza się bardzo wolno, ciężki pancerz
    }
}
