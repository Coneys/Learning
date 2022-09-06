package patterns.structural.singleton


object UnknownCategory {
    init {
        println("Initialized now")
    }
}

fun main() {
    //add coroutines
    println("Application started")
    println("No singleton initialization...")
    println(UnknownCategory)
    println(UnknownCategory == UnknownCategory)
    println(UnknownCategory === UnknownCategory)
    println("Application finished")
}